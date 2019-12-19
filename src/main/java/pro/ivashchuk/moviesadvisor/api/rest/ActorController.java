package pro.ivashchuk.moviesadvisor.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.ivashchuk.moviesadvisor.domain.Actor;
import pro.ivashchuk.moviesadvisor.repository.JpaActorRepository;

import java.util.List;

@RestController("RestActorController")
@RequestMapping(path = "/api/actors", produces = "application/json")
public class ActorController {

    private JpaActorRepository jpaActorRepository;

    public ActorController(JpaActorRepository jpaActorRepository) {
        this.jpaActorRepository = jpaActorRepository;
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return jpaActorRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Actor getActorById(@PathVariable("id") Long id) {
        return jpaActorRepository.findById(id).get();
    }

    @PostMapping(path = "/addNewActor", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Actor addNewActor(@RequestBody Actor actor) {
        return jpaActorRepository.save(actor);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Actor updateActor(@PathVariable("id") Long id, @RequestBody Actor actor) {
        return jpaActorRepository.save(actor);
    }

    @PatchMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Actor patchActor(@PathVariable("id") Long id, @RequestBody Actor patchActor) {
        Actor actor = jpaActorRepository.findById(id).get();
        if (patchActor.getName() != null) {
            actor.setName(patchActor.getName());
            //etc
        }

        return jpaActorRepository.save(actor);
    }
}
