package n2MySQL.MySQLdatabase;

import n2MySQL.DAO.TreeDAO;
import n2MySQL.MySQLdatabase.queries.MySQLQueries;
import n2MySQL.beans.Tree;
import n2MySQL.handlers.AppHandler;
import n2MySQL.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreeSQL implements TreeDAO {

    private final Connection connection;

    public TreeSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Tree tree) {
        try {
            PreparedStatement productst = connection.prepareStatement(MySQLQueries.INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement treest = connection.prepareStatement((MySQLQueries.INSERT_TREE));
            productst.setString(1, tree.getName());
            productst.setDouble(2, tree.getSellPrice());
            productst.setDouble(3, tree.getCostPrice());
            productst.setInt(4, tree.getStock());
            productst.setString(5, "Tree");
            productst.executeUpdate();

            try (ResultSet rs = productst.getGeneratedKeys()) {
                int product_id = -1;
                if (rs.next()) {
                    product_id = rs.getInt(1);
                    treest.setInt(1, product_id);
                    treest.setInt(2, tree.getHeight());
                    treest.executeUpdate();

                }

            }
            AppHandler.printText(Constants.Menus.PRODUCT_ADDED);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tree tree) {
        try {
            PreparedStatement treest = connection.prepareStatement(MySQLQueries.UPDATE_TREE);
            treest.setString(1,tree.getName());
            treest.setInt(2, tree.getHeight());
            treest.setDouble(3, tree.getSellPrice());
            treest.setDouble(4, tree.getCostPrice());
            treest.setInt(5, tree.getProductId());
            treest.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Tree tree) {
        try {
            PreparedStatement treest = connection.prepareStatement(MySQLQueries.DELETE_TREE);
            PreparedStatement productst = connection.prepareStatement(MySQLQueries.DELETE_PRODUCT);
            treest.setInt(1, tree.getProductId());
            treest.executeUpdate();

            productst.setInt(1, tree.getProductId());
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
    public List<Tree> readAll() {
        ArrayList<Tree> allTrees = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement(MySQLQueries.GET_ALL_TREES);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                double sellPrice = resultSet.getDouble("sell_price");
                double costPrice = resultSet.getDouble("cost_price");
                int stock = resultSet.getInt("stock");
                int height = resultSet.getInt("height");

                Tree tree = new Tree (productId, name, sellPrice, costPrice,stock,height);
                allTrees.add(tree);
            }

        }catch (SQLException e) {
            e.printStackTrace();

        }

        return allTrees;
    }

    @Override
    public Tree getOne(String id) {
        Tree tree = null;
        try {
            PreparedStatement st = connection.prepareStatement(MySQLQueries.GET_TREE);
            st.setString(1, id);
            ResultSet resultSet = st.executeQuery(); {
                if (resultSet.next()) {
                    int productId = resultSet.getInt("product_id");
                    String name = resultSet.getString("name");
                    double sellPrice = resultSet.getDouble("sell_price");
                    double costPrice = resultSet.getDouble("cost_price");
                    int stock = resultSet.getInt("stock");
                    int height = resultSet.getInt("height");

                    tree = new Tree (productId,name, sellPrice, costPrice, stock, height);
                } else {
                    AppHandler.printText(Constants.Menus.PRODUCT_NOT_FOUND);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tree;
    }
}
