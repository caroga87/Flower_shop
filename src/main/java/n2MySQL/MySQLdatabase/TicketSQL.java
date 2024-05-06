package n2MySQL.MySQLdatabase;

import n2MySQL.DAO.TicketDAO;
import n2MySQL.MySQLdatabase.queries.MySQLQueries;
import n2MySQL.beans.Ticket;
import n2MySQL.beans.TicketData;
import n2MySQL.handlers.AppHandler;
import n2MySQL.utils.Constants;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketSQL implements TicketDAO {
    private final Connection connection;

    public TicketSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Ticket ticket) {
        try {
            // Insertar el ticket en la tabla Ticket
            try (PreparedStatement statement = connection.prepareStatement(MySQLQueries.INSERT_TICKET, Statement.RETURN_GENERATED_KEYS)) {
                Timestamp creationDateTime = Timestamp.valueOf(ticket.getCreationDateTime());
                statement.setTimestamp(1, creationDateTime);
                statement.setDouble(2, ticket.getTotalAmount());
                statement.executeUpdate();

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        ticket.setTicketId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating ticket failed, no ID obtained.");
                    }
                }
            }

            // Insertar los datos del ticket en la tabla TicketData
            try (PreparedStatement ticketDataSt = connection.prepareStatement(MySQLQueries.INSERT_TICKETDATA)) {
                for (TicketData ticketData : ticket.getProducts().values()) {
                    ticketDataSt.setInt(1, ticket.getTicketId());
                    ticketDataSt.setInt(2, ticketData.getProductId());
                    ticketDataSt.setInt(3, ticketData.getQuantity());
                    ticketDataSt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            // Manejar la excepción de manera adecuada
            System.err.println("Error al crear el ticket: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Ticket ticket) {
         try (PreparedStatement statement = connection.prepareStatement(MySQLQueries.UPDATE_TICKET)) {
            Timestamp creationDateTime = Timestamp.valueOf(ticket.getCreationDateTime());
            statement.setTimestamp(1, creationDateTime);
            statement.setDouble(2, ticket.getTotalAmount());
            statement.setInt(3, ticket.getTicketId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Ticket ticket) {

        try (PreparedStatement deleteTicketStatement = connection.prepareStatement(MySQLQueries.DELETE_TICKET);
             PreparedStatement deleteTicketDataStatement = connection.prepareStatement(MySQLQueries.DELETE_TICKETDATA)) {
            deleteTicketStatement.setInt(1, ticket.getTicketId());
            deleteTicketStatement.executeUpdate();

            deleteTicketDataStatement.setInt(1, ticket.getTicketId());
            int rowsAffected = deleteTicketDataStatement.executeUpdate();
            if (rowsAffected > 0) {
                AppHandler.printText(Constants.Menus.DELETED);
            } else {
                AppHandler.printText(Constants.Menus.PRODUCT_NOT_FOUND);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ticket> readAll() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        String query = "SELECT * FROM Ticket";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ticket_id");
                Timestamp creationDateTime = resultSet.getTimestamp("creation_date_time");
                double totalAmount = resultSet.getDouble("total_amount");

                Ticket ticket = new Ticket();
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public Ticket getOne(String id) {
        String query = "SELECT * FROM Ticket WHERE ticket_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int ticketId = resultSet.getInt("ticket_id");
                Timestamp creationDateTime = resultSet.getTimestamp("creation_date_time");
                double totalAmount = resultSet.getDouble("total_amount");

                return new Ticket();
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
}
