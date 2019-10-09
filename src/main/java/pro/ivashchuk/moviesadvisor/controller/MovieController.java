package pro.ivashchuk.moviesadvisor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.moviesadvisor.domain.Movie;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String getAllMovies(){
        return "All_Movies";
    }

    @GetMapping("/addNewMovie")
    public String addNewMovie(Model model) {
        model.addAttribute(new Movie());
        return "Add_New_Movie";
    }

    @PostMapping("/addNewMovie")
    public String processNewMovie (Movie movie) {
        return "redirect:/";
    }
}
