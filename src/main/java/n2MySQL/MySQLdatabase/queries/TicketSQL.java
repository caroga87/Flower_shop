package n2MySQL.MySQLdatabase.queries;

import n2MySQL.DAO.TicketDAO;
import n2MySQL.beans.*;
import n2MySQL.MySQLdatabase.connections.SQLDatabaseConnection;
import n2MySQL.enums.ProductTypeEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TicketSQL implements TicketDAO {

    private final SQLDatabaseConnection connectionManager;

    public TicketSQL(SQLDatabaseConnection connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void create(Ticket newTicket) {
        try {
            Connection connection = connectionManager.openConnection();
            PreparedStatement statement = connection.prepareStatement(MySQLQueries.INSERT_TICKET, Statement.RETURN_GENERATED_KEYS);
            statement.setTimestamp(1, Timestamp.valueOf(newTicket.getCreationDateTime()));
            statement.setDouble(2, newTicket.getTotalAmount());
            statement.executeUpdate();
            ResultSet generateKey = statement.getGeneratedKeys();

            if (generateKey.next()) {
                int ticketId = generateKey.getInt(1);
                newTicket.setTicketId(ticketId);

                Map<Product, Integer> products = newTicket.getProducts();
                for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                    Product product = entry.getKey();
                    Integer amount = entry.getValue();

                    PreparedStatement statementProductTicket = connection.prepareStatement(MySQLQueries.INSERT_PRODUCT_TICKET);
                    statementProductTicket.setInt(1, amount);
                    statementProductTicket.setInt(2, product.getProductId());
                    statementProductTicket.setInt(3, ticketId);
                    statementProductTicket.executeUpdate();
                }
            } else {
                throw new SQLException("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
        public void update (Ticket object){

        }

        @Override
        public void delete (Ticket object){

        }

        @Override
        public List<Ticket> readAll () {
            List<Ticket> tickets = new ArrayList<>();
            try (Connection connection = connectionManager.openConnection();
                 PreparedStatement statement = connection.prepareStatement(MySQLQueries.READ_ALL_TICKETS);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Ticket ticket = createTicketFromResultSet(resultSet);
                    tickets.add(ticket);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return tickets;
        }

    private Ticket createTicketFromResultSet(ResultSet resultSet) throws SQLException {
        int ticketId = resultSet.getInt("idticket");
        String date = String.valueOf(resultSet.getDate("date"));
        double totalPrice = resultSet.getDouble("totalPrice");

        Map<Product, Integer> productTickets = getProductTicketsForTicket(ticketId);

        return new Ticket(ticketId, productTickets, totalPrice, date);
    }

    private Map<Product, Integer> getProductTicketsForTicket(int ticketId) {
        Map<Product, Integer>productTickets = new HashMap<>();
        try (Connection connection = connectionManager.openConnection();
             PreparedStatement productStatement = connection.prepareStatement(MySQLQueries.SELECT_PRODUCTS_FOR_TICKET)) {
            productStatement.setInt(1, ticketId);
            try (ResultSet productRs = productStatement.executeQuery()) {
                while (productRs.next()) {
                    Product product = createProductFromResultSet(productRs);
                    int quantity = productRs.getInt("amount");
                    productTickets.put(product, quantity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productTickets;
    }
    private Product createProductFromResultSet(ResultSet resultSet) throws SQLException {
        int productId = resultSet.getInt("idproduct");
        String productName = resultSet.getString("name");
        int quantity = resultSet.getInt("quantity");
        double sellPrice = resultSet.getDouble("sell_price");
        double costPrice = resultSet.getDouble("cost_price");
        ProductTypeEnum type = ProductTypeEnum.valueOf(resultSet.getString("type"));
        String attribute = resultSet.getString("attribute");

        switch (type) {
            case FLOWER:
                return new Flower<>(productId, productName, sellPrice, costPrice, quantity, attribute);
            case TREE:
                return new Tree<>(productId, productName, sellPrice, costPrice, quantity, Double.parseDouble(attribute));
            case DECORATION:
                return new Decoration<>(productId, productName, sellPrice, costPrice, quantity, attribute);
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
        @Override
        public Ticket getOne (String id){
            return null;
        }
    }
