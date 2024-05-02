package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    // JDBC URL, username, and password for your MySQL database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/productplatform";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "105";

    // Method to establish a database connection and return a Connection object
    public static Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException (driver not found)
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found", e);
        }
    }
}
