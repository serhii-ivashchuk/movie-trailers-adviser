package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pro.ivashchuk.moviesadvisor.domain.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcMovieRepository implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMovieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Movie> findAll() {

        return jdbcTemplate.query("select id, movie_Name, ranking from Movie", this::mapRowToMovie);
    }

    @Override
    public Movie findById(String id) {
        return null;
    }

    @Override
    public Movie save(Movie movie) {
        return null;
    }

    private Movie mapRowToMovie(ResultSet resultSet, int rowNum) throws SQLException {
        return new Movie(
                resultSet.getLong("id"),
                resultSet.getString("movie_Name"),
                resultSet.getInt("ranking"));
    }
}
