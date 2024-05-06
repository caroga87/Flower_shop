package n2MySQL.MySQLdatabase.queries;

import n2MySQL.DAO.DecorationDAO;
import n2MySQL.MySQLdatabase.connections.SQLDatabaseConnection;
import n2MySQL.beans.Decoration;
import n2MySQL.handlers.AppHandler;
import n2MySQL.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DecorationSQL implements DecorationDAO {
    private final SQLDatabaseConnection connectionManager;

    public DecorationSQL(SQLDatabaseConnection connectionManager) {
        this.connectionManager = connectionManager;
    }
    @Override
    public void create(Decoration decoration) {
        try (Connection connection = connectionManager.openConnection();
            PreparedStatement productst = connection.prepareStatement(MySQLQueries.INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement decorationst = connection.prepareStatement((MySQLQueries.INSERT_DECORATION))){
            productst.setString(1, decoration.getName());
            productst.setDouble(2, decoration.getSellPrice());
            productst.setDouble(3, decoration.getCostPrice());
            productst.setInt(4, decoration.getStock());
            productst.setString(5, "Decoration");
            productst.executeUpdate();

            try (ResultSet rs = productst.getGeneratedKeys()) {
                int product_id = -1;
                if (rs.next()) {
                    product_id = rs.getInt(1);
                    decorationst.setInt(1, product_id);
                    decorationst.setString(2, decoration.getMaterial());
                    decorationst.executeUpdate();

                }
            }
            AppHandler.printText(Constants.Menus.PRODUCT_ADDED);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Decoration decoration) {
        try (Connection connection = connectionManager.openConnection();
            PreparedStatement flowerst = connection.prepareStatement(MySQLQueries.UPDATE_DECORATION)){
            flowerst.setString(1, decoration.getName());
            flowerst.setString(2, decoration.getMaterial());
            flowerst.setDouble(3, decoration.getSellPrice());
            flowerst.setDouble(4, decoration.getCostPrice());
            flowerst.setInt(5, decoration.getProductId());
            flowerst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void delete(Decoration decoration) {
        try (Connection connection = connectionManager.openConnection();
            PreparedStatement decorationst = connection.prepareStatement(MySQLQueries.DELETE_DECORATION);
            PreparedStatement productst = connection.prepareStatement(MySQLQueries.DELETE_PRODUCT)){
            decorationst.setInt(1, decoration.getProductId());
            decorationst.executeUpdate();

            productst.setInt(1, decoration.getProductId());
            int rowsAffected = productst.executeUpdate();
            if (rowsAffected >0) {
                AppHandler.printText(Constants.Menus.DELETED);
            }else {
                AppHandler.printText(Constants.Menus.PRODUCT_NOT_FOUND);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Decoration> readAll() {
        ArrayList<Decoration> allDecorations = new ArrayList<>();
        try(Connection connection = connectionManager.openConnection();
            PreparedStatement st = connection.prepareStatement(MySQLQueries.GET_ALL_DECORATIONS)){
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                double sellPrice = resultSet.getDouble("sell_price");
                double costPrice = resultSet.getDouble("cost_price");
                int stock = resultSet.getInt("stock");
                String material = resultSet.getString("material");

                Decoration decoration = new Decoration(name, sellPrice, costPrice,stock,material);
                allDecorations.add(decoration);
            }

        }catch (SQLException e) {
            e.printStackTrace();

        }

        return allDecorations;
    }

    @Override
    public Decoration getOne(String id) {
        Decoration decoration = null;
        try (Connection connection = connectionManager.openConnection();
            PreparedStatement st = connection.prepareStatement(MySQLQueries.GET_DECORATION)){
            st.setString(1, id);
            ResultSet resultSet = st.executeQuery(); {
                if (resultSet.next()) {
                    int productId = resultSet.getInt("product_id");
                    String name = resultSet.getString("name");
                    double sellPrice = resultSet.getDouble("sell_price");
                    double costPrice = resultSet.getDouble("cost_price");
                    int stock = resultSet.getInt("stock");
                    String material = resultSet.getString("material");

                    decoration = new Decoration(name, sellPrice, costPrice, stock, material);
                } else {
                    System.out.println("No se encontró una flor con el ID especificado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de la excepción
        }
        return decoration;
    }

}