package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    public static Connection pgCon;
    public Connection openPGConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            pgCon = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/payment_gateway", "postgres", "1234");
            return pgCon;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection(Connection con) throws SQLException {
        con.close();
    }


}
