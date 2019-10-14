package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pro.ivashchuk.moviesadvisor.domain.Movie;

@Repository
public class JdbcMovieRepository implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMovieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
