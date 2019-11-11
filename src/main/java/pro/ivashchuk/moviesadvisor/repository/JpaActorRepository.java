package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.ivashchuk.moviesadvisor.domain.Actor;

import java.util.List;
import java.util.Optional;

public interface JpaActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findAll();
    Optional<Actor> findById(Long id);
    Actor save(Actor actor);
}
