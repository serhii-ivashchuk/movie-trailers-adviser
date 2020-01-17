package pro.ivashchuk.moviesadvisor.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieTest {

    final static Logger log = LoggerFactory.getLogger(MovieTest.class);

    @Autowired
    TestEntityManager testEntityManager;

    Movie movie = new Movie(null, "Green Mile", 10, "Green Mile.jpg", "youtube.com/watch?v=Ki4haFrqSrw");

    @Test
    public void shouldGenerateId() {
        testEntityManager.persistFlushFind(movie);
        assertNotNull(movie.getId());
    }

    @Test
    public void shouldCreateNewMovie() {
//        testEntityManager.persistFlushFind(movie);
//        assertNotNull(movie.getId());

    }

}
