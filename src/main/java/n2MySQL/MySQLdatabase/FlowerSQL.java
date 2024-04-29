package n2MySQL.MySQLdatabase;

import n2MySQL.DAO.FlowerDAO;
import n2MySQL.beans.Flower;
import java.sql.*;
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
            System.out.println("Product was added successfully");
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
            flowerst.setInt(5, flower.getProductId());
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
            flowerst.setInt(1, flower.getProductId());
            flowerst.executeUpdate();

            productst.setInt(1, flower.getProductId());
            int rowsAffected = productst.executeUpdate();
            if (rowsAffected >0) {
                System.out.println("Flower deleted successfully");
            }else {
                System.out.println("The product ID does not find ");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Flower> read() {
        return null;
    }

    @Override
    public Flower getOne(String id) {
        return null;
    }
}
