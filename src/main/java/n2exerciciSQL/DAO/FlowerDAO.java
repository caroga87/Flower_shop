package n2exerciciSQL.DAO;

import n2exerciciSQL.beans.Flower;
import n2exerciciSQL.utils.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class FlowerDAO implements DAO {
    private Connection connection;

    public FlowerDAO (Connection connection){
        this.connection= connection;
    }

    public void insert(Flower flower) throws Exception {
        String query= "INSERT INTO flowers (name, colour, price) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query) ){
            statement.setString(1, Input.inputString("Flower's name:"));
            statement.setString(2, Input.inputString("Flower's colour:"));
            statement.setDouble(3, Input.inputDouble("Flower's price:"));
            statement.executeLargeUpdate();
        }

    }


    @Override
    public void insert(Object object) throws Exception {

    }

    @Override
    public void modify(Object object) throws Exception {

    }

    @Override
    public void remove(Object object) throws Exception {

    }

    @Override
    public List list() throws Exception {
        return null;
    }
}
