package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.ivashchuk.moviesadvisor.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface JpaMovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();
    Optional<Movie> findById(Long id);
    Movie save(Movie movie);
    void delete(Movie movie);
}
