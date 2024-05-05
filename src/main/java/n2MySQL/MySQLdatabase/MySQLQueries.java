package n2MySQL.MySQLdatabase;

public class MySQLQueries {

    public static final String INSERT_PRODUCT = "INSERT INTO product (name, sell_price, cost_price, stock, type) VALUES (?,?,?,?,?)";
    public static final String INSERT_FLOWER = "INSERT INTO flower (flower_id, colour) VALUES (?, ?)";
    public static final String INSERT_DECORATION= "INSERT INTO decoration (decoration_id, material) VALUES (?, ?)";
    public static final String INSERT_TREE ="INSERT INTO tree (tree_id, height) VALUES (?,?)";
    public static final String INSERT_TICKET ="INSERT INTO Ticket (creation_date_time, total_amount) VALUES (?, ?)";
    public static final String INSERT_TICKETDATA= "INSERT INTO ticketdata (ticket_id, product_id, quantity) VALUES (?, ?, ?)";
    public static final String DELETE_PRODUCT = "DELETE FROM product WHERE product_id = (?)";
    public static final String DELETE_FLOWER = "DELETE FROM flower WHERE flower_id = (?)";
    public static final String DELETE_DECORATION = "DELETE FROM decoration WHERE decoration_id = (?)";
    public static final String DELETE_TREE = "DELETE FROM tree WHERE tree_id = (?)";
    public static final String DELETE_TICKET = "DELETE FROM ticket WHERE ticket_id = ?";
    public static final String DELETE_TICKETDATA = "DELETE FROM ticketdata WHERE ticket_id = ?";
    public static final String UPDATE_DECORATION = "UPDATE decorations SET name = ?, material = ?, price = ? WHERE decoration_id = ?";
    public static final String UPDATE_FLOWER = "UPDATE flower SET name =?, colour=?, sell_price=?, cost_price=? WHERE flower_id=?";
    public static final String UPDATE_TREE = "UPDATE tree SET name =?, height=?, sell_price=?, cost_price=?, WHERE tree_id=?";
    public static final String UPDATE_TICKET = "UPDATE ticket SET creation_date_time = ?, total_amount = ? WHERE ticket_id = ?";
    public static final String GET_ALL_FLOWERS = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, f.colour " +
                                                     "FROM Product p " +
                                                        "JOIN Flower f ON p.product_id = f.flower_id";
   // public static final String GET_ALL_PRODUCTS = "SELECT * FROM products";
    public static final String GET_ALL_TREES = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, t.height " +
                                                    "FROM Product p" +
                                                        "JOIN Tree t ON p.product_id=t.tree_id";
    public static final String GET_ALL_DECORATIONS = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, d.material " +
                                                        "FROM Product p" +
                                                            "JOIN Decoration d ON p.product_id = d.decoration_id";
    public static final String GET_FLOWER = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, f.colour " +
                                                "FROM Product p " +
                                                    "JOIN Flower f ON p.product_id = f.flower_id " +
                                                     "WHERE p.name = ?";
    public static final String GET_TREE = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, t.height " +
                                                "FROM Product p " +
                                                    "JOIN Tree t ON p.product_id = t.tree_id " +
                                                        "WHERE p.name = ?";
    public static final String GET_DECORATION = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, d.material " +
                                                    "FROM Product p " +
                                                     "JOIN Decoration d ON p.product_id = d.decoration_id " +
                                                         "WHERE p.name = ?";


}

