package admin;

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

@WebServlet("/productsmanagement")
public class ProductManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Products");
             ResultSet rs = stmt.executeQuery()) {

            StringBuilder productList = new StringBuilder();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int stockQuantity = rs.getInt("stock_quantity");

                productList.append("Product ID: ").append(productId)
                            .append(", Name: ").append(productName)
                            .append(", Description: ").append(description)
                            .append(", Price: ").append(price)
                            .append(", Stock Quantity: ").append(stockQuantity)
                            .append("<br>");
            }

            response.getWriter().println(productList.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("addProduct")) {
                String productName = request.getParameter("productName");
                String description = request.getParameter("description");
                double price = Double.parseDouble(request.getParameter("price"));
                int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));

                try (Connection conn = DatabaseUtil.getConnection();
                     PreparedStatement stmt = conn.prepareStatement("INSERT INTO Products (product_name, description, price, stock_quantity) VALUES (?, ?, ?, ?)")) {

                    stmt.setString(1, productName);
                    stmt.setString(2, description);
                    stmt.setDouble(3, price);
                    stmt.setInt(4, stockQuantity);

                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendRedirect("error.jsp");
                }

                response.sendRedirect("products");
            } else if (action.equals("updateProduct")) {
                int productId = Integer.parseInt(request.getParameter("productId"));
                String productName = request.getParameter("productName");
                String description = request.getParameter("description");
                double price = Double.parseDouble(request.getParameter("price"));
                int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));

                try (Connection conn = DatabaseUtil.getConnection();
                     PreparedStatement stmt = conn.prepareStatement("UPDATE Products SET product_name = ?, description = ?, price = ?, stock_quantity = ? WHERE product_id = ?")) {

                    stmt.setString(1, productName);
                    stmt.setString(2, description);
                    stmt.setDouble(3, price);
                    stmt.setInt(4, stockQuantity);
                    stmt.setInt(5, productId);

                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendRedirect("error.jsp");
                }

                response.sendRedirect("products");
            } else if (action.equals("deleteProduct")) {
                int productId = Integer.parseInt(request.getParameter("productId"));

                try (Connection conn = DatabaseUtil.getConnection();
                     PreparedStatement stmt = conn.prepareStatement("DELETE FROM Products WHERE product_id = ?")) {

                    stmt.setInt(1, productId);
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendRedirect("error.jsp");
                }

                response.sendRedirect("products");
            }
        }
    }
}
