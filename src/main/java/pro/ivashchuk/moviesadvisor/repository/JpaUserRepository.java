package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.ivashchuk.moviesadvisor.domain.User;

public interface JpaUserRepository extends JpaRepository<User, Long> {
}