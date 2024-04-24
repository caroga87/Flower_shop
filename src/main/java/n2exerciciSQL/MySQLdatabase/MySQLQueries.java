package n2exerciciSQL.MySQLdatabase;

public class MySQLQueries {

    public static final String INSERT_FLOWER = "INSERT INTO flowers (name, colour, price, products_product_id) VALUES (?, ?, ?, ?)";
    public static final String INSERT_DECORATION= "INSERT INTO decorations (name, material, price, products_product_id) VALUES (?, ?, ?, ?)";
    public static final String INSERT_SALE = "INSERT INTO sales (time_created, total_paid) VALUES (?, ?)";
    public static final String UPDATE_DECORATION = "UPDATE decorations SET name = ?, material = ?, price = ? WHERE decoration_id = ?";
    public static final String DELETE_PRODUCT = "DELETE FROM products WHERE product_id = (?)";
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

