package pro.ivashchuk.moviesadvisor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.moviesadvisor.domain.Movie;
import pro.ivashchuk.moviesadvisor.repository.JpaMovieRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    final static Logger log = LoggerFactory.getLogger(MovieController.class);

    private JpaMovieRepository jpaMovieRepository;

    public MovieController(JpaMovieRepository jpaMovieRepository) {
        this.jpaMovieRepository = jpaMovieRepository;
    }


    @GetMapping
    public String getAllMovies(Model model) {
        log.info("getAllMovies() of MovieController is invoked");
        List<Movie> movies = new ArrayList<>(jpaMovieRepository.findAll());
        model.addAttribute("movies", movies);
        return "All_Movies";
    }

    @GetMapping("/Movie/{id}")
    public String getMovieById(@PathVariable("id") Long id, Model model) {
        log.info("getMovieById() of MovieController is invoked");
        System.out.println("getMovieById() of MovieController is invoked");
        Movie movie = jpaMovieRepository.findById(id).get();
        System.out.println("movie "+movie);
        model.addAttribute("movie", movie);
        return "Movie";
    }

    @GetMapping("/addNewMovie")
    public String addNewMovie(Model model) {
        log.info("addNewMovie() of MovieController is invoked");
        model.addAttribute("movie", new Movie());
        return "Add_New_Movie";
    }

    @PostMapping("/addNewMovie")
    public String processNewMovie(@Valid Movie movie) {
        log.info("processNewMovie (http post()) of MovieController is invoked");
        jpaMovieRepository.save(movie);
        log.info("processNewMovie()  jpaMovieRepository.save() is invoked");
        log.info("Movie: " + movie);
        return "redirect:/movies";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") Long id, Model model) {
        jpaMovieRepository.delete(jpaMovieRepository.findById(id).get());
        return "redirect:/actors";
    }
}
