import customer.DatabaseUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int totalProducts = getProductCount();
            int totalCustomers = getCustomerCount();
            int totalOrders = getOrderCount();

            // Construct HTML content for the dashboard
            StringBuilder dashboardContent = new StringBuilder();
            dashboardContent.append("<h2>Admin Dashboard</h2>");
            dashboardContent.append("<p>Total Products: ").append(totalProducts).append("</p>");
            dashboardContent.append("<p>Total Customers: ").append(totalCustomers).append("</p>");
            dashboardContent.append("<p>Total Orders: ").append(totalOrders).append("</p>");

            // Display dashboard content
            response.getWriter().println(dashboardContent.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    // Method to retrieve total number of products from database
    private int getProductCount() throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS product_count FROM Products");
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("product_count");
            }
            return 0; // Default to 0 if no products found
        }
    }

    // Method to retrieve total number of customers from database
    private int getCustomerCount() throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS customer_count FROM Customers");
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("customer_count");
            }
            return 0; // Default to 0 if no customers found
        }
    }

    // Method to retrieve total number of orders from database
    private int getOrderCount() throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS order_count FROM Orders");
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("order_count");
            }
            return 0; // Default to 0 if no orders found
        }
    }
}
