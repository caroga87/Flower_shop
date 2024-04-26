package n2MySQL.MySQLdatabase;

import n2MySQL.DAO.FlowerDAO;
import n2MySQL.beans.Flower;
import n2MySQL.utils.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FlowerSQL implements FlowerDAO {
    private  final Connection connection;
    public FlowerSQL (Connection connection){
        this.connection= connection;
    }

    @Override
    public void create(Flower flower) {
        String name = Input.inputString("Flower's name:");
        String colour = Input.inputString("Colour:");
        double price = Input.inputDouble("Flower's price:");
        try (PreparedStatement st = connection.prepareStatement(MySQLQueries.INSERT_FLOWER)){
            st.setString(1, name);
            st.setString(2, colour);
            st.setDouble(3, price);
            st.setInt(4, flower.getIdProduct() );
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Decoración insertada correctamente."); // modificar en ingles y en otra clase :)
            } else {
                System.out.println("No se pudo insertar la decoración.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar la decoración: " + e.getMessage());
        }
    }

    @Override
    public void update(Flower object) {

    }

    @Override
    public void delete(Flower object) {

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
