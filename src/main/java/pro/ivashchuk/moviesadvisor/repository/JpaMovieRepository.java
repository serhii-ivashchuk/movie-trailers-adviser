package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.ivashchuk.moviesadvisor.domain.Movie;

import javax.persistence.Id;
import java.util.List;

public interface JpaMovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();
    Movie save(Movie movie);
}
