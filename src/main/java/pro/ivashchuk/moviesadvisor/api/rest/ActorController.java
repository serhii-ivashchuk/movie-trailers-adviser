package pro.ivashchuk.moviesadvisor.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.ivashchuk.moviesadvisor.domain.Actor;
import pro.ivashchuk.moviesadvisor.repository.JpaActorRepository;

import java.util.List;

@RestController("RestActorController")
@RequestMapping(path="/api/actors", produces = "application/json")
public class ActorController {

    private JpaActorRepository jpaActorRepository;

    public ActorController(JpaActorRepository jpaActorRepository) {
        this.jpaActorRepository = jpaActorRepository;
    }

    @GetMapping
    public List<Actor> getAllActors(){
        return jpaActorRepository.findAll();
    }
}
