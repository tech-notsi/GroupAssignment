import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Order;

public class OrderDAO {
    private Connection connection;

    public OrderDAO() {
        try {
            this.connection = DBConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addOrder(Order order) throws SQLException {
        String query = "INSERT INTO Orders (order_date, total_amount, customer_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, (Date) order.getOrderDate());
            stmt.setDouble(2, order.getTotalAmount());
            stmt.setInt(3, order.getCustomerId());

            stmt.executeUpdate();
        }
    }

    public void updateOrderStatus(int orderId, String newStatus) throws SQLException {
        String query = "UPDATE Orders SET status = ? WHERE order_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newStatus);
            stmt.setInt(2, orderId);

            stmt.executeUpdate();
        }
    }

    public void deleteOrder(int orderId) throws SQLException {
        String query = "DELETE FROM Orders WHERE order_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, orderId);

            stmt.executeUpdate();
        }
    }
}
