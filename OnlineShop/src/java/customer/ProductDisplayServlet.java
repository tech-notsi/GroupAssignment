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

@WebServlet("/productDisplay")
public class ProductDisplayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Products");
             ResultSet rs = stmt.executeQuery()) {

            // Construct HTML content to display product information
            StringBuilder productList = new StringBuilder();
            productList.append("<h2>Available Products</h2>");
            productList.append("<ul>");

            while (rs.next()) {
                String productName = rs.getString("product_name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");

                productList.append("<li>")
                            .append("<strong>").append(productName).append("</strong>")
                            .append("<br>Description: ").append(description)
                            .append("<br>Price: $").append(price)
                            .append("</li>");
            }

            productList.append("</ul>");

            // Set response content type to HTML
            response.setContentType("text/html");
            // Write the product list HTML to the response
            response.getWriter().println(productList.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to error page on database error
        }
    }
}
