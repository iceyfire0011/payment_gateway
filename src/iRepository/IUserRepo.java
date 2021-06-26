package iRepository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepo {
    String create(User user) throws Exception;

    String createRange(List<User> users) throws SQLException;

    String update(User user) throws SQLException;

    String updateRange(List<User> users) throws SQLException;

    String delete(long id) throws SQLException;

    String deleteRange(List<User> users) throws SQLException;

    User retrieve(long id) throws SQLException;

    List<User> userList() throws SQLException;

}
