package pro.ivashchuk.moviesadvisor.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pro.ivashchuk.moviesadvisor.domain.Movie;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMovieRepositoryTest {

    @Autowired
    JpaMovieRepository jpaMovieRepository;

    Movie movie;

    @Before
    public void setUp() {
        movie = new Movie(null, "Green Mile", 10, "Green Mile.jpg", "youtube.com/watch?v=Ki4haFrqSrw");
    }

    @Test
    public void shouldFindMovieById() {
        jpaMovieRepository.save(movie);
        Optional<Movie> foundMovie = jpaMovieRepository.findById(movie.getId());
        assertEquals(movie.getId(), foundMovie.get().getId());
    }
}