package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.ivashchuk.moviesadvisor.domain.User;

import javax.persistence.Id;
import java.util.List;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    User findById(Id id);
    User findByUsername(String username);
    User save(User user);
    void delete(User user);
}
