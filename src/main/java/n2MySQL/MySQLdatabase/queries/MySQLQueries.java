package n2MySQL.MySQLdatabase.queries;

public class MySQLQueries {
    // queries del producte

    public static final String INSERT_PRODUCT = "INSERT INTO product(name, quantity, sell_price, cost_price, type) VALUES(?, ?, ?, ?,?)";

    public static final String INSERT_ATTRIBUTE = "INSERT INTO %s (product_idproduct, %s) VALUES (?, ?)";

    public static final String UPDATE_PRODUCT= "UPDATE product SET name = ?, quantity = ?, sell_price = ?,cost_price = ?, type = ? WHERE idproduct = ?";

    public static final String DELETE_PRODUCT = "DELETE product, flower, decoration, tree " +
            "FROM product " +
            "LEFT JOIN flower ON product.idproduct = flower.product_idproduct " +
            "LEFT JOIN decoration ON product.idproduct = decoration.product_idproduct " +
            "LEFT JOIN tree ON product.idproduct = tree.product_idproduct " +
            "WHERE product.idproduct = ?";

    public static final String READ_ONE_BY_ID = "SELECT p.idproduct, p.name, p.quantity, p.sell_price, p.cost_price, p.type, " +
            "COALESCE(f.color, t.height, d.material) AS attribute " +
            "FROM product p " +
            "LEFT JOIN flower f ON p.idproduct = f.product_idproduct " +
            "LEFT JOIN decoration d ON p.idproduct = d.product_idproduct " +
            "LEFT JOIN tree t ON p.idproduct = t.product_idproduct " +
            "WHERE p.idproduct = ?";

    public static final String READ_ONE_BY_NAME = "SELECT * FROM product WHERE name = ?";

    public static final String READ_ALL = "SELECT p.idproduct, p.name, p.quantity, p.sell_price, p.cost_price, p.type, " +
            "COALESCE(f.color, t.height, d.material) AS attribute " +
            "FROM product p " +
            "LEFT JOIN flower f ON p.idproduct = f.product_idproduct " +
            "LEFT JOIN decoration d ON p.idproduct = d.product_idproduct " +
            "LEFT JOIN tree t ON p.idproduct = t.product_idproduct " +
            "ORDER BY FIELD(p.type, 'TREE', 'FLOWER', 'DECORATION'), p.idproduct ASC;";

    // queries ticket
    public static final String INSERT_TICKET ="INSERT INTO ticket(date, totalPrice) VALUES(?, ?)";

    public static final String INSERT_PRODUCT_TICKET = "INSERT INTO product_ticket (amount, product_idproduct, ticket_idticket) VALUES (?, ?, ?)";

    public static final String READ_ALL_TICKETS  = "SELECT * FROM ticket";

    public static final String SELECT_PRODUCTS_FOR_TICKET =
            "SELECT p.idproduct, p.name, p.quantity, p.sell_price, p.cost_price, p.type, " +
                    "COALESCE(f.color, t.height, d.material) AS attribute " +
                    "FROM product p " +
                    "LEFT JOIN product_ticket pt ON p.idproduct = pt.product_idproduct " +
                    "LEFT JOIN flower f ON p.idproduct = f.product_idproduct " +
                    "LEFT JOIN decoration d ON p.idproduct = d.product_idproduct " +
                    "LEFT JOIN tree t ON p.idproduct = t.product_idproduct " +
                    "WHERE pt.ticket_idticket = ?";



}

