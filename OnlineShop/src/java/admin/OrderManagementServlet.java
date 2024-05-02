package admin;

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
import customer.DatabaseUtil;

@WebServlet("/orderManagement")
public class OrderManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch and display order list
        displayOrderList(response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process order data (e.g., update order status)
        String orderIdStr = request.getParameter("orderId");
        String newStatus = request.getParameter("newStatus");

        if (orderIdStr != null && newStatus != null) {
            try {
                int orderId = Integer.parseInt(orderIdStr);

                // Update order status in the database
                updateOrderStatus(orderId, newStatus);

                // Redirect back to order list page after updating
                displayOrderList(response);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp"); // Redirect to error page on invalid input
            }
        } else {
            response.sendRedirect("error.jsp"); // Redirect to error page if parameters are missing
        }
    }

    // Method to update order status in the database
    private void updateOrderStatus(int orderId, String newStatus) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE orders SET status = ? WHERE order_id = ?")) {

            stmt.setString(1, newStatus);
            stmt.setInt(2, orderId);
            stmt.executeUpdate(); // Execute the update query
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error (e.g., log error, throw exception)
        }
    }

    // Method to fetch and display order list
    private void displayOrderList(HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders");
             ResultSet rs = stmt.executeQuery()) {

            // Construct HTML content for displaying order list
            StringBuilder orderList = new StringBuilder();
            orderList.append("<h2>Order List</h2>");
            orderList.append("<table border='1'>");
            orderList.append("<tr><th>Order ID</th><th>Customer Username</th><th>Order Date</th><th>Total Amount</th><th>Status</th></tr>");

            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                String customerUsername = rs.getString("customer_username");
                String orderDate = rs.getString("order_date");
                double totalAmount = rs.getDouble("total_amount");
                String status = rs.getString("status");

                // Append row for each order
                orderList.append("<tr>")
                         .append("<td>").append(orderId).append("</td>")
                         .append("<td>").append(customerUsername).append("</td>")
                         .append("<td>").append(orderDate).append("</td>")
                         .append("<td>").append(totalAmount).append("</td>")
                         .append("<td>").append(status).append("</td>")
                         .append("</tr>");
            }

            orderList.append("</table>");

            // Set response content type to HTML
            response.setContentType("text/html");
            // Write the order list HTML to the response
            response.getWriter().println(orderList.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to error page on database error
        }
    }
}
