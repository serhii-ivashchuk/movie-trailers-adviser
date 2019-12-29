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
public class ActorTest {

    final static Logger log = LoggerFactory.getLogger(MovieTest.class);

    @Autowired
    TestEntityManager testEntityManager;

    Actor actor = new Actor("Tom", "Hanks", "Tom Hanks.jpg");

    @Test
    public void shouldGenerateId() {
        testEntityManager.persistFlushFind(actor);
        assertNotNull(actor.getId());
    }
}