package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User showUserById(int id);
    void saveUser(User user);
    void deleteUser(int id);
    void updateUser(int id, User user);
}
