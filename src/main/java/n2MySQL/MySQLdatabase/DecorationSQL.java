package n2MySQL.MySQLdatabase;

import n2MySQL.DAO.DecorationDAO;
import n2MySQL.beans.Decoration;
import n2MySQL.utils.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DecorationSQL implements DecorationDAO {

    private  final Connection connection;
    public DecorationSQL (Connection connection){
        this.connection= connection;
    }
    @Override
    public void create(Decoration decoration) {
        String name = Input.inputString("Decoration's name:");
        String type = Input.inputString("Wood or plastic:");
        double price = Input.inputDouble("Decoration's price:");
        try (PreparedStatement st = connection.prepareStatement(MySQLQueries.INSERT_DECORATION)){
            st.setString(1, name);
            st.setString(2, type);
            st.setDouble(3, price);
            st.setInt(4, decoration.getIdProduct());

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
    public void update(Decoration decoration) {

        int decorationId = Input.inputInt("Id of the decoration to update:");
        String newName = Input.inputString("New name:");
        String newType = Input.inputString("New material (wood or plastic):");
        double newPrice = Input.inputDouble("New price:");

        try (PreparedStatement st = connection.prepareStatement(MySQLQueries.UPDATE_DECORATION)) {
            st.setString(1, newName);
            st.setString(2, newType);
            st.setDouble(3, newPrice);
            st.setInt(4, decorationId);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Decoration updated successfully.");
            } else {
                System.out.println("No decoration found with the specified ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating decoration: " + e.getMessage());
        }
    }

    @Override
    public void delete(Decoration object) {

    }

    @Override
    public List<Decoration> read() {
        return null;
    }

    @Override
    public Decoration getOne(String id) {
        return null;
    }
}


