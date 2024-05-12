package n2MySQL.MySQLdatabase.queries;

import n2MySQL.DAO.ProductDAO;
import n2MySQL.MySQLdatabase.connections.SQLDatabaseConnection;
import n2MySQL.beans.*;
import n2MySQL.enums.ProductTypeEnum;
import n2MySQL.handlers.AppHandler;
import n2MySQL.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSQL implements ProductDAO  {

    private final SQLDatabaseConnection connectionManager;

    public ProductSQL(SQLDatabaseConnection connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void create(Product product) {
        try (Connection connection = connectionManager.openConnection();
             PreparedStatement productSt = connection.prepareStatement(MySQLQueries.INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)){
            // Insertar el producto
            productSt.setString(1, product.getName());
            productSt.setInt(2, product.getStock());
            productSt.setDouble(3, product.getSellPrice());
            productSt.setDouble(4, product.getCostPrice());
            productSt.setString(5, product.getProductType().name());
            productSt.executeUpdate();

            // Obtener el ID del producto insertado
            int productId = -1;
            ResultSet generatedKeys = productSt.getGeneratedKeys();
            if (generatedKeys.next()) {
                productId = generatedKeys.getInt(1);
            }

            // Determinar el atributo específico del producto (else-if ternario)
            String specificAttribute = (product.getProductType() == ProductTypeEnum.TREE) ? "height" :
                    ((product.getProductType() == ProductTypeEnum.FLOWER) ? "color" : "material");

            // Insertar el atributo específico
            String formattedQuery = String.format(MySQLQueries.INSERT_ATTRIBUTE, product.getProductType().name().toLowerCase(), specificAttribute);
            try (PreparedStatement attributeSt = connection.prepareStatement(formattedQuery)) {
                attributeSt.setInt(1, productId);
                attributeSt.setString(2, product.getAttribute().toString());
                attributeSt.executeUpdate();
            }

            AppHandler.printText(Constants.Menus.PRODUCT_ADDED);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Product product) {
        try {
            Connection connection = connectionManager.openConnection();
            PreparedStatement statement = connection.prepareStatement(MySQLQueries.UPDATE_PRODUCT);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getStock());
            statement.setDouble(3, product.getSellPrice());
            statement.setDouble(4, product.getCostPrice());
            statement.setString(5, product.getProductType().toString());
            statement.setInt(6, product.getProductId());
            statement.executeUpdate();
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("No product found with ID: " + product.getProductId());
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }




    @Override
    public void delete(Product product) {
        try {
            Connection connection =  connectionManager.openConnection();
            PreparedStatement statement = connection.prepareStatement(MySQLQueries.DELETE_PRODUCT);
            statement.setInt(1, product.getProductId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }



    @Override
    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = connectionManager.openConnection();
             PreparedStatement statement = connection.prepareStatement(MySQLQueries.READ_ALL);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product product = createProductFromResultSet(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product getOne(Integer id) {
        Product product = null;
        try (Connection connection = connectionManager.openConnection();
            PreparedStatement statement = connection.prepareStatement(MySQLQueries.READ_ONE_BY_ID)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                product = createProductFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return product;
    }

    private Product createProductFromResultSet(ResultSet resultSet) throws SQLException {
        int productId = resultSet.getInt("idproduct");
        String name = resultSet.getString("name");
        int stock = resultSet.getInt("stock");
        double sellPrice = resultSet.getDouble("sell_price");
        double costPrice = resultSet.getDouble("cost_price");
        String typeString = resultSet.getString("type");
        String attribute = resultSet.getString("attribute");

        ProductTypeEnum type = ProductTypeEnum.valueOf(typeString);

        switch (type) {
            case FLOWER:
                return new Flower(productId, name, sellPrice, costPrice,stock, attribute);
            case DECORATION:
                return new Decoration(productId, name, sellPrice, costPrice,stock, attribute);
            case TREE:
                return new Tree(productId, name, sellPrice, costPrice,stock,Double.parseDouble(attribute));
            default:
                throw new IllegalArgumentException("Invalid product type: " + typeString);
        }
    }

    public Product getOneByName(String name) {
        Product product = null;
        try (Connection connection = connectionManager.openConnection();
             PreparedStatement statement = connection.prepareStatement(MySQLQueries.READ_ONE_BY_NAME)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                product = createProductFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    public List<Product> getFlowers() {
        List<Product> allProducts = readAll();
        return allProducts.stream()
                .filter(product -> product.getProductType() == ProductTypeEnum.FLOWER)
                .collect(Collectors.toList());
    }


    public List<Product> getTrees() {
        List<Product> allProducts = readAll();
        return allProducts.stream()
                .filter(product -> product.getProductType() == ProductTypeEnum.TREE)
                .collect(Collectors.toList());
    }


    public List<Product> getDecorations() {
        List<Product> allProducts = readAll();
        return allProducts.stream()
                .filter(product -> product.getProductType() == ProductTypeEnum.DECORATION)
                .collect(Collectors.toList());
    }
}
