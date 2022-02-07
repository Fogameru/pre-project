package web.repository;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUser();

    void addUser(User user);

    User getUser(int id);

    void updateUser(User user);

    void deleteUser(int id);
}
