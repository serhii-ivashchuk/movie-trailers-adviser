package pro.ivashchuk.moviesadvisor.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleTest {

    @Autowired
    TestEntityManager testEntityManager;

    Role role = new Role("user");

    @Test
    public void shouldGenerateId() {
        testEntityManager.persistFlushFind(role);
        assertNotNull(role.getId());
    }

}