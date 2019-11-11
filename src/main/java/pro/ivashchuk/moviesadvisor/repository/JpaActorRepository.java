package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.ivashchuk.moviesadvisor.domain.Actor;

public interface JpaActorRepository extends JpaRepository<Actor, Long> {
}
