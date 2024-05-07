package n2MySQL.MySQLdatabase.queries;

import n2MySQL.DAO.ProductDAO;
import n2MySQL.MySQLdatabase.connections.SQLDatabaseConnection;
import n2MySQL.beans.Product;

import java.util.List;

public class ProductSQL implements ProductDAO  {

    private final SQLDatabaseConnection connectionManager;

    public ProductSQL(SQLDatabaseConnection connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void create(Product object) {

    }

    @Override
    public void update(Product object) {

    }

    @Override
    public void delete(Product object) {

    }

    @Override
    public List<Product> readAll() {
        return null;
    }

    @Override
    public Product getOne(Integer id) {
        return null;
    }
}
