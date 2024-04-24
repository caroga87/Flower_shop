package n2exerciciSQL.DAO;

import n2exerciciSQL.database.SQLDatabaseConnection;
import n2exerciciSQL.utils.Input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO {
    private Connection connection = SQLDatabaseConnection.getInstance().getConnection();


    public ProductDAO() throws SQLException {
    }
    public int insertProduct(Product product) {
        int productId = -1;
        String productQuery = "INSERT INTO products (stock) VALUES (?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement productStatement = connection.prepareStatement(productQuery,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            productStatement.setInt(1, product.getStock());
            productStatement.executeUpdate();

            // Obtener el ID generado para el producto insertado
            ResultSet generatedKeys = productStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                productId = generatedKeys.getInt(1);
            }

            // Llamar a la clase DAO específica según el tipo de producto
            switch (product.getType()) {
                case FLOWER:
                    FlowerDAO flowerDAO = new FlowerDAO(connection);
                    flowerDAO.insertFlower((Flower) product, productId);
                    break;
                case TREE:
                    TreeDAO treeDAO = new TreeDAO(connection);
                    treeDAO.insertTree((Tree) product, productId);
                    break;
                case DECORATION:
                    DecorationDAO decorationDAO = new DecorationDAO(connection);
                    decorationDAO.insertDecoration((Decoration) product, productId);
                    break;
                default:
                    System.out.println("Tipo de producto no válido.");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productId;
    }
}
}
