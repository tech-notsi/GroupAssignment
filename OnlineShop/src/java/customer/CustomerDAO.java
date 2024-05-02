package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Customer;

public class CustomerDAO {
    private Connection connection;

    public CustomerDAO() {
        try {
            this.connection = DBConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isValidCustomer(String username, String password) throws SQLException {
        String query = "SELECT * FROM Customers WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void addCustomer(Customer customer) throws SQLException {
        String query = "INSERT INTO Customers (username, password, full_name, email) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, customer.getUsername());
            stmt.setString(2, customer.getPassword());
            stmt.setString(3, customer.getFullName());
            stmt.setString(4, customer.getEmail());

            stmt.executeUpdate();
        }
    }

    public void updateCustomer(Customer customer) throws SQLException {
        String query = "UPDATE Customers SET password = ?, full_name = ?, email = ? WHERE username = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, customer.getPassword());
            stmt.setString(2, customer.getFullName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getUsername());

            stmt.executeUpdate();
        }
    }

    public void deleteCustomer(String username) throws SQLException {
        String query = "DELETE FROM Customers WHERE username = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);

            stmt.executeUpdate();
        }
    }

    boolean validateCustomer(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
