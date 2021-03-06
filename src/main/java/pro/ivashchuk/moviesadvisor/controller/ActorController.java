package pro.ivashchuk.moviesadvisor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.moviesadvisor.domain.Actor;
import pro.ivashchuk.moviesadvisor.domain.Movie;
import pro.ivashchuk.moviesadvisor.repository.JpaActorRepository;
import pro.ivashchuk.moviesadvisor.repository.JpaMovieRepository;
import pro.ivashchuk.moviesadvisor.service.ActorServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/actors")
public class ActorController {

    final static Logger log = LoggerFactory.getLogger(ActorController.class);

    private final JpaActorRepository jpaActorRepository;
    private final JpaMovieRepository jpaMovieRepository;
    @Autowired
    private final ActorServiceImpl actorServiceImpl;


    public ActorController(JpaActorRepository jpaActorRepository, JpaMovieRepository jpaMovieRepository, ActorServiceImpl actorServiceImpl) {
        this.jpaActorRepository = jpaActorRepository;
        this.jpaMovieRepository = jpaMovieRepository;
        this.actorServiceImpl = actorServiceImpl;
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

    @GetMapping("/actor/{id}")
    public String getActorById(@PathVariable("id") Long id, Model model) {
        Actor actor = jpaActorRepository.findById(id).get();
        model.addAttribute("actor", actor);
        Set<Movie> playedMovies = actor.getPlayedMovies();
        model.addAttribute("playedMovies", playedMovies);
        return "Actor";
    }

    @GetMapping("/actor/{id}/addNewMovie")
    public String getAddNewMovieToActorById(@PathVariable("id") Long id, Model model) {
        Actor actor = jpaActorRepository.findById(id).get();
        model.addAttribute("actor", actor);
        model.addAttribute("movie", new Movie());
        return "Add_New_Movie";
    }

    @PostMapping("/actor/{id}/addNewMovie")
    public String processAddNewMovieToActorById(@PathVariable("id") Long id, Movie movie) {
        Actor actor = jpaActorRepository.findById(id).get();
        String movieName = movie.getMovieName();
        Optional<Movie> findByMovieName = jpaMovieRepository.findByMovieName(movieName);
        if (!findByMovieName.isPresent()) {
            System.out.println("Movie: '" + movieName + "' not found");
        }
        jpaMovieRepository.save(movie);
        jpaActorRepository.save(actorServiceImpl.addMovieToActor(movie, actor));
        return "redirect:/actors/actor/" + actor.getId();
    }

    @GetMapping("/actor/{id}/patch")
    public String getActorForPatchById(@PathVariable("id") Long id, Model model) {
        Actor patchActor = jpaActorRepository.findById(id).get();
        model.addAttribute("patchActor", patchActor);
        return "Update_Actor";
    }

    @GetMapping("/deleteActor/{id}")
    public String deleteActor(@PathVariable("id") Long id, Model model) {
        jpaActorRepository.delete(jpaActorRepository.findById(id).get());
        return "redirect:/actors";
    }
}
