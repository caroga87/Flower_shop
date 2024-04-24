package n2exerciciSQL.DAO;

import n2exerciciSQL.beans.Product;
import n2exerciciSQL.MySQLdatabase.SQLDatabaseConnection;

import java.sql.*;

public class ProductDAO {
    private Connection connection;


    public ProductDAO() throws SQLException {
        this.connection =SQLDatabaseConnection.getInstance().getConnection();
    }

}
