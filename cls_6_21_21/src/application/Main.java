package application;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class Main {
    private static Connection con;
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/payment_gateway", "postgres", "1234");
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setUsername("AngryBird");
            user.setPassword("1234");
            user.setFullName("Full angry bird");

            insert(user);
            selectAllUsers();
        } catch (ClassNotFoundException | SQLException ce) {
            ce.printStackTrace();
        }
    }

    private static void selectAllUsers() throws SQLException {
        var query = "select * from tbl_user;";
        var statement = con.prepareStatement(query);
        var resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " | " + resultSet.getString(2) + " | " + resultSet.getString(3) + " | " + resultSet.getString(4));
        }
    }

    public static void insert(User user) throws SQLException {
        var query = "INSERT INTO public.tbl_user(id, username, password, full_name) VALUES (?, ?, ?, ?);";
        var pstmt = con.prepareStatement(query);
        pstmt.setString(1,user.getId());
        pstmt.setString(2,user.getUsername());
        pstmt.setString(3,user.getPassword());
        pstmt.setString(4,user.getFullName());
        pstmt.executeUpdate();
    }
}
