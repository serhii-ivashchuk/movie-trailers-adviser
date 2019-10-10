package pro.ivashchuk.moviesadvisor.repository;

import pro.ivashchuk.moviesadvisor.domain.User;

public interface UserRepository {
    Iterable<User> getAllUsers();
}
