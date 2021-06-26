package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    private String dbManager;
    private String host;
    private String port;
    private String db;
    private String username;
    private String password;
    public Connection openPGConnection() {
        try {
            Connection pgCon;
            dbManager = "postgresql";
            host = "localhost";
            port = "5432";
            db = "payment_gateway";
            username = "postgres";
            password = "1234";
            Class.forName("org.postgresql.Driver");
            pgCon = DriverManager.getConnection(
                    "jdbc:" + dbManager + "://" + host + ":" + port + "/" + db, username, password);
            return pgCon;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
