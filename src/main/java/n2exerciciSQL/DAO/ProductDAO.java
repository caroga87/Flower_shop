package n2exerciciSQL.DAO;

import n2exerciciSQL.database.SQLDatabaseConnection;
import n2exerciciSQL.utils.Input;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO {
    private Connection connection = SQLDatabaseConnection.getInstance().getConnection();


    public ProductDAO() throws SQLException {
    }
}
