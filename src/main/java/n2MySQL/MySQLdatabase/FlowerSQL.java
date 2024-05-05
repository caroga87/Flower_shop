package n2MySQL.MySQLdatabase;

import n2MySQL.DAO.FlowerDAO;
import n2MySQL.beans.Flower;
import n2MySQL.handlers.AppHandler;
import n2MySQL.utis.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlowerSQL implements FlowerDAO {
    private  final Connection connection;
    public FlowerSQL (Connection connection){
        this.connection= connection;
    }

    @Override
    public void create(Flower flower) {

        try {
            PreparedStatement productst = connection.prepareStatement(MySQLQueries.INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement flowerst = connection.prepareStatement((MySQLQueries.INSERT_FLOWER));
            productst.setString(1, flower.getName());
            productst.setDouble(2, flower.getSellPrice());
            productst.setDouble(3, flower.getCostPrice());
            productst.setInt(4, flower.getStock());
            productst.setString(5, "Flower");
            productst.executeUpdate();

            try (ResultSet rs = productst.getGeneratedKeys()) {
                int product_id = -1;
                if (rs.next()) {
                    product_id = rs.getInt(1);
                    flowerst.setInt(1, product_id);
                    flowerst.setString(2, flower.getColour());
                    flowerst.executeUpdate();
                }
            }
            AppHandler.printText(Constants.Menus.PRODUCT_ADDED);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Flower flower) {
        try {
            PreparedStatement flowerst = connection.prepareStatement(MySQLQueries.UPDATE_FLOWER);
            flowerst.setString(1,flower.getName());
            flowerst.setString(2, flower.getColour());
            flowerst.setDouble(3, flower.getSellPrice());
            flowerst.setDouble(4, flower.getCostPrice());
            flowerst.setInt(5, flower.getProduct_id());
            flowerst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Flower flower) {
        try {
            PreparedStatement flowerst = connection.prepareStatement(MySQLQueries.DELETE_FLOWER);
            PreparedStatement productst = connection.prepareStatement(MySQLQueries.DELETE_PRODUCT);
            flowerst.setInt(1, flower.getProduct_id());
            flowerst.executeUpdate();

            productst.setInt(1, flower.getProduct_id());
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
    public List<Flower> readAll() {
        ArrayList<Flower> allFlowers = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement(MySQLQueries.GET_ALL_FLOWERS);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                double sellPrice = resultSet.getDouble("sell_price");
                double costPrice = resultSet.getDouble("cost_price");
                int stock = resultSet.getInt("stock");
                String colour = resultSet.getString("colour");

                Flower flower = new Flower(productId, name, sellPrice, costPrice,stock,colour);
                allFlowers.add(flower);
            }

        }catch (SQLException e) {
            e.printStackTrace();

        }

        return allFlowers;
    }

    @Override
    public Flower getOne(String flowerName) {
        Flower flower = null;
        try {
            PreparedStatement st = connection.prepareStatement(MySQLQueries.GET_FLOWER);
            st.setString(1, flowerName);
            ResultSet resultSet = st.executeQuery(); {
                if (resultSet.next()) {
                    int productId = resultSet.getInt("product_id");
                    String name = resultSet.getString("name");
                    double sellPrice = resultSet.getDouble("sell_price");
                    double costPrice = resultSet.getDouble("cost_price");
                    int stock = resultSet.getInt("stock");
                    String colour = resultSet.getString("colour");

                    flower = new Flower(productId, name, sellPrice, costPrice, stock, colour);
                } else {
                    AppHandler.printText(Constants.Menus.PRODUCT_NOT_FOUND);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flower;
    }
}

