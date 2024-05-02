package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionManager {
    private static final String DB_URL = "productPlatform";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1105";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
}
