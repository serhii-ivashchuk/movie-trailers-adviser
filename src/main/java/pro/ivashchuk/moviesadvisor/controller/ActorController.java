package pro.ivashchuk.moviesadvisor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pro.ivashchuk.moviesadvisor.domain.Actor;
import pro.ivashchuk.moviesadvisor.repository.JpaActorRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/actors")
public class ActorController {

    final static Logger log = LoggerFactory.getLogger(ActorController.class);

    private final JpaActorRepository jpaActorRepository;
    private final JpaMovieRepository jpaMovieRepository;


    public ActorController(JpaActorRepository jpaActorRepository, JpaMovieRepository jpaMovieRepository, ActorServiceImpl actorServiceImpl) {
        this.jpaActorRepository = jpaActorRepository;
    }

    @GetMapping
    public String getAllActors(Model model) {
        log.info("getAllActors() of ActorController is invoked");
        List<Actor> actors = new ArrayList<>(jpaActorRepository.findAll());
        model.addAttribute("actors", actors);
        return "All_actors";
    }

    @GetMapping("/addNewActor")
    public String addNewActor(Model model) {
        log.info("addNewActor() of ActorController is invoked");
        model.addAttribute("actor", new Actor());
        return "Add_New_Actor";
    }

    @PostMapping("/addNewActor")
    public String processNewActor(@Valid Actor actor) {
        log.info("processNewActor() of ActorController is invoked");
        jpaActorRepository.save(actor);
        log.info("processNewActor() > jpaActorRepository.save() is invoked");
        log.info("Actor: "+actor);
        return "redirect:/actors";
    }

    @GetMapping("/Actor/{id}")
    public String getActorById(@PathVariable("id") Long id, Model model) {
        Actor actor = jpaActorRepository.findById(id).get();
        model.addAttribute("actor", actor);
        Set<Movie> playedMovies = actor.getPlayedMovies();
        model.addAttribute("playedMovies", playedMovies);
        return "Actor";
    }

    @GetMapping("/deleteActor/{id}")
    public String deleteActor(@PathVariable("id") Long id, Model model){
        jpaActorRepository.delete(jpaActorRepository.findById(id).get());
        return "redirect:/actors";
    }
}
