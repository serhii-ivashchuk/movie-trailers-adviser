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
public class UserTest {

    @Autowired
    TestEntityManager testEntityManager;

    User user = new User("user", "pass", "passphrase");

    @Test
    public void shouldGenerateId() {
        testEntityManager.persistFlushFind(user);
        assertNotNull(user.getId());
    }
}