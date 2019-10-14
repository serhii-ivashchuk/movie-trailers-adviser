package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.stereotype.Repository;
import pro.ivashchuk.moviesadvisor.domain.Movie;

@Repository
public class JdbcMovieRepository implements MovieRepository {

    @Override
    public Iterable<Movie> findAll() {
        return null;
    }

    @Override
    public Movie findById(String id) {
        return null;
    }

    @Override
    public Movie save(Movie movie) {
        return null;
    }
}
