package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;
@Transactional
public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    List<User> listUsers();
}
