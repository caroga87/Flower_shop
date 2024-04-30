package n2MySQL.MySQLdatabase;

public class MySQLQueries {

    public static final String INSERT_PRODUCT = "INSERT INTO product (name, sell_price, cost_price, stock, type) VALUES (?,?,?,?,?)";
    public static final String INSERT_FLOWER = "INSERT INTO flower (flower_id, colour) VALUES (?, ?)";
    public static final String INSERT_DECORATION= "INSERT INTO decoration (decoration_id, material) VALUES (?, ?)";
    public static final String INSERT_TREE ="INSERT INTO tree (tree_id, height) VALUES (?,?)";
    public static final String INSERT_TICKET ="INSERT INTO Ticket (creation_date_time, total_amount) VALUES (?, ?)";
    public static final String DELETE_PRODUCT = "DELETE FROM product WHERE product_id = (?)";
    public static final String DELETE_FLOWER = "DELETE FROM flower WHERE flower_id = (?)";
    public static final String DELETE_DECORATION = "DELETE FROM decoration WHERE decoration_id = (?)";
    public static final String DELETE_TREE = "DELETE FROM tree WHERE tree_id = (?)";
    public static final String UPDATE_DECORATION = "UPDATE decorations SET name = ?, material = ?, price = ? WHERE decoration_id = ?";
    public static final String UPDATE_FLOWER = "UPDATE flower SET name =?, colour=?, sell_price=?, cost_price=? WHERE flower_id=?";
    public static final String UPDATE_TREE = "UPDATE tree SET name =?, height=?, sell_price=?, cost_price=?, WHERE tree_id=?";
    public static final String GET_ALL_FLOWERS = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, f.colour " +
                                                    "FROM Product p, Flower f " +
                                                        "WHERE p.product_id = f.flower_id";
    public static final String GET_ALL_PRODUCTS = "SELECT * FROM products";
    public static final String GET_ALL_TREES = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, t.height " +
                                                    "FROM Product p, tree t " +
                                                        "WHERE p.product_id = t.tree_id";
    public static final String GET_ALL_DECORATIONS = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, d.material " +
                                                        "FROM Product p, decoration d " +
                                                            "WHERE p.product_id = d.decoration_id";
    public static final String GET_FLOWER = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, f.colour " +
                                                "FROM Product p, Flower f " +
                                                    "WHERE p.product_id = f.flower_id AND p.product_id = ?";
    public static final String GET_TREE = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, t.height " +
                                                "FROM Product p, Tree t" +
                                                    "WHERE p.product_id = t.tree_id AND p.product_id = ?";
    public static final String GET_DECORATION = "SELECT p.product_id, p.name, p.sell_price, p.cost_price, p.stock, d.material " +
                                                    "FROM Product p, Decoration d " +
                                                        "WHERE p.product_id = d.decoration_id AND p.product_id = ?";


}

