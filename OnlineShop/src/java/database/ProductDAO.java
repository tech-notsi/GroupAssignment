import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Product;

public class ProductDAO {
    private Connection connection;

    public ProductDAO() {
        try {
            this.connection = DBConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO Products (product_name, description, price, stock_quantity) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStockQuantity());

            stmt.executeUpdate();
        }
    }

    public void updateProduct(Product product) throws SQLException {
        String query = "UPDATE Products SET product_name = ?, description = ?, price = ?, stock_quantity = ? WHERE product_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStockQuantity());
            stmt.setInt(5, product.getProductId());

            stmt.executeUpdate();
        }
    }

    public void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM Products WHERE product_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, productId);

            stmt.executeUpdate();
        }
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM Products";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int stockQuantity = rs.getInt("stock_quantity");

                Product product = new Product(productId, productName, description, price, stockQuantity);
                productList.add(product);
            }
        }

        return productList;
    }

    public Product getProductById(int productId) throws SQLException {
        String query = "SELECT * FROM Products WHERE product_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, productId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String productName = rs.getString("product_name");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int stockQuantity = rs.getInt("stock_quantity");

                    return new Product(productId, productName, description, price, stockQuantity);
                }
            }
        }

        return null;
    }

    public List<Product> getProductsByCategory(String category) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM Products WHERE category = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, category);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    String productName = rs.getString("product_name");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int stockQuantity = rs.getInt("stock_quantity");

                    Product product = new Product(productId, productName, description, price, stockQuantity);
                    productList.add(product);
                }
            }
        }

        return productList;
    }

    // Add more methods for other product-related operations as needed
}
