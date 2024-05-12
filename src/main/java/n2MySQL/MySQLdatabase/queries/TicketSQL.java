package n2MySQL.MySQLdatabase.queries;

import n2MySQL.DAO.TicketDAO;
import n2MySQL.MySQLdatabase.connections.SQLDatabaseConnection;
import n2MySQL.beans.Ticket;
import n2MySQL.handlers.AppHandler;
import n2MySQL.utils.Constants;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketSQL implements TicketDAO {
    private final SQLDatabaseConnection connectionManager;

    public TicketSQL(SQLDatabaseConnection connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void create(Ticket object) {

    }

    @Override
    public void update(Ticket object) {

    }

    @Override
    public void delete(Ticket object) {

    }

    @Override
    public List<Ticket> readAll() {
        return List.of();
    }

    @Override
    public Ticket getOne(String id) {
        return null;
    }
}
