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

@WebServlet("/admin/customers")
public class CustomerManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve customer data from the database
            StringBuilder customerList = new StringBuilder();
            customerList.append("<h2>Customer List</h2>");
            customerList.append("<table border='1'>");
            customerList.append("<tr><th>Customer ID</th><th>Name</th><th>Email</th></tr>");

            // Establish database connection and execute query
            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customers");
                 ResultSet rs = stmt.executeQuery()) {

                // Process each customer record and add to the HTML table
                while (rs.next()) {
                    int customerId = rs.getInt("customer_id");
                    String customerName = rs.getString("customer_name");
                    String email = rs.getString("email");

                    customerList.append("<tr>")
                                .append("<td>").append(customerId).append("</td>")
                                .append("<td>").append(customerName).append("</td>")
                                .append("<td>").append(email).append("</td>")
                                .append("</tr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp"); // Redirect to error page on database error
                return;
            }

            customerList.append("</table>");

            // Set response content type to HTML
            response.setContentType("text/html");
            // Write the HTML table to the response
            response.getWriter().println(customerList.toString());
        } catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to error page on IO error
        }
    }
}
