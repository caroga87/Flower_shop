package n2MySQL.MySQLdatabase;

import n2MySQL.DAO.TicketDataDAO;
import n2MySQL.beans.TicketData;

import java.sql.Connection;
import java.util.List;

public class TicketDataSQL implements TicketDataDAO {

    private final Connection connection;

    public TicketDataSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(TicketData ticketData) {

    }

    @Override
    public void update(TicketData ticketData) {

    }

    @Override
    public void delete(TicketData ticketData) {

    }

    @Override
    public List<TicketData> readAll() {
        return null;
    }

    @Override
    public TicketData getOne(String id) {
        return null;
    }
}
