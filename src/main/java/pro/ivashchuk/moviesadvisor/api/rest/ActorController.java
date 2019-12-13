package pro.ivashchuk.moviesadvisor.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.ivashchuk.moviesadvisor.repository.JpaActorRepository;

@RestController
@RequestMapping(path="/api/actors", produces = "application/json")
public class ActorController {

    private JpaActorRepository jpaActorRepository;

    public ActorController(JpaActorRepository jpaActorRepository) {
        this.jpaActorRepository = jpaActorRepository;
    }
}
