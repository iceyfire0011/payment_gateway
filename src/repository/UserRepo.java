package repository;

import config.DbConfig;
import iRepository.IUserRepo;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class UserRepo implements IUserRepo {


    @Override
    public String create(User user) throws SQLException {
        Connection con = new DbConfig().openPGConnection();
        var query = "INSERT INTO public.tbl_user(id, username, password, full_name) VALUES (?, ?, ?, ?);";
        var pstmt = con.prepareStatement(query);
        pstmt.setString(1, UUID.randomUUID().toString());
        pstmt.setString(2, user.getUsername());
        pstmt.setString(3, user.getPassword());
        pstmt.setString(4, user.getFullName());
        pstmt.executeUpdate();
        con.close();
        return user.toString();
    }

    @Override
    public String createRange(List<User> users) throws SQLException {
        Connection con = new DbConfig().openPGConnection();
        var query = "INSERT INTO public.tbl_user(id, username, password, full_name) VALUES (?, ?, ?, ?);";
        var s = "";
        for (User u : users) {
            var pstmt = con.prepareStatement(query);
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, u.getUsername());
            pstmt.setString(3, u.getPassword());
            pstmt.setString(4, u.getFullName());
            pstmt.executeUpdate();
            s += u.toString() + "\n";
        }
        con.close();

        return s;
    }

    @Override
    public String update(User user) throws SQLException {
        return null;
    }

    @Override
    public String updateRange(List<User> users) throws SQLException {
        return null;
    }

    @Override
    public String delete(long id) throws SQLException {
        return null;
    }

    @Override
    public String deleteRange(List<User> users) throws SQLException {
        return null;
    }

    @Override
    public User retrieve(long id) throws SQLException {
        Connection con = new DbConfig().openPGConnection();
        var query = "select * from tbl_user where id= '" + id + "';";
        var statement = con.prepareStatement(query);
        var resultSet = statement.executeQuery();
        User user = new User();
        while (resultSet.next()) {
            user.setId(resultSet.getString(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setFullName(resultSet.getString(4));
        }
        con.close();
        return user;
    }

    @Override
    public List<User> userList() throws SQLException {
        Connection con = new DbConfig().openPGConnection();
        var query = "select * from tbl_user;";
        var statement = con.prepareStatement(query);
        var resultSet = statement.executeQuery();
        List<User> users = new LinkedList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getString(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setFullName(resultSet.getString(4));
            users.add(user);
        }
        con.close();
        return users;
    }
}
