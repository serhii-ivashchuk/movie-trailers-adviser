package pro.ivashchuk.moviesadvisor.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pro.ivashchuk.moviesadvisor.domain.Actor;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaActorRepositoryTest {

    @Autowired
    JpaActorRepository jpaActorRepository;

    Actor actor;

    @Before
    public void setUp() {
        actor = new Actor(1l, "Tom", "Hanks", "Green Mile");
    }

    @Test
    public void shouldFindMovieById() {
        jpaActorRepository.save(actor);
        Optional<Actor> foundActor = jpaActorRepository.findById(actor.getId());
        assertEquals(actor.getId(), foundActor.get().getId());
    }
}