package customer;

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
import jakarta.servlet.http.HttpSession;

@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the logged-in customer's username from session
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("customerLoggedIn") == null) {
            // Redirect to login page if customer is not logged in
            response.sendRedirect("customerlogin.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");

        // Fetch order history for the customer from the database
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders WHERE customer_username = ? ORDER BY order_date DESC")) {

            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                // Construct HTML content for displaying order history
                StringBuilder orderHistory = new StringBuilder();
                orderHistory.append("<h2>Order History</h2>");
                orderHistory.append("<table border='1'>");
                orderHistory.append("<tr><th>Order ID</th><th>Order Date</th><th>Total Amount</th><th>Status</th></tr>");

                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    String orderDate = rs.getString("order_date");
                    double totalAmount = rs.getDouble("total_amount");
                    String status = rs.getString("status");

                    // Append row for each order
                    orderHistory.append("<tr>")
                                .append("<td>").append(orderId).append("</td>")
                                .append("<td>").append(orderDate).append("</td>")
                                .append("<td>").append(totalAmount).append("</td>")
                                .append("<td>").append(status).append("</td>")
                                .append("</tr>");
                }

                orderHistory.append("</table>");

                // Set response content type to HTML
                response.setContentType("text/html");
                // Write the order history HTML to the response
                response.getWriter().println(orderHistory.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Redirect to error page on database error
            response.sendRedirect("error.jsp");
        }
    }
}
