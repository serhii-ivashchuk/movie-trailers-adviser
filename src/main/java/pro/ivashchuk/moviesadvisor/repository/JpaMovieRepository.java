package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.ivashchuk.moviesadvisor.domain.Movie;

import java.util.List;
import java.util.Optional;

@Repository("movieRepository")
public interface JpaMovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();

    Optional<Movie> findById(Long id);

    Optional<Movie> findByMovieName(String movieName);

    Movie save(Movie movie);

    void delete(Movie movie);
}