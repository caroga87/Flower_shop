package n2MySQL.MySQLdatabase;

public class MySQLQueries {

    public static final String INSERT_PRODUCT = "INSERT INTO product (name, sell_price, cost_price, stock, type) VALUES (?,?,?,?,?)";
    public static final String INSERT_FLOWER = "INSERT INTO flower (flower_id, colour) VALUES (?, ?)";
    public static final String INSERT_DECORATION= "INSERT INTO decoration (decoration_id, material) VALUES (?, ?)";
    public static final String INSERT_TREE ="INSERT INTO tree (tree_id, height) VALUES (?,?)";
    public static final String DELETE_PRODUCT = "DELETE FROM product WHERE product_id = (?)";
    public static final String DELETE_FLOWER = "DELETE FROM flower WHERE product_id = (?)";
    public static final String DELETE_DECORATION = "DELETE FROM decoration WHERE product_id = (?)";
    public static final String DELETE_TREE = "DELETE FROM tree WHERE product_id = (?)";
    public static final String UPDATE_DECORATION = "UPDATE decorations SET name = ?, material = ?, price = ? WHERE decoration_id = ?";
    public static final String UPDATE_FLOWER = "UPDATE flower SET name =?, colour=?, sell_price=?, cost_price=? WHERE flower_id=?";
    public static final String GET_ALL_FLOWERS = "SELECT * FROM flowers";
    public static final String GET_ALL_PRODUCTS = "SELECT * FROM products";
    public static final String GET_ALL_TREES = "SELECT * FROM trees";
    public static final String GET_ALL_DECORATIONS = "SELECT * FROM decorations";
    public static final String GET_ALL_SALES = "SELECT * FROM sales";
    public static final String GET_FLOWER = "SELECT * FROM flowers WHERE LOWER(name) = LOWER (?)";
    public static final String GET_TREE = "SELECT * FROM trees WHERE LOWER(name) = LOWER(?)";
    public static final String GET_DECORATION = "SELECT * FROM decorations WHERE LOWER(name) = LOWER(?)";
    public static final String GET_SALE = "SELECT * FROM sales WHERE id = ?";

}

