package pro.ivashchuk.moviesadvisor.service;

import pro.ivashchuk.moviesadvisor.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    void addUser(User user);
    void updateUser(User user);
}
