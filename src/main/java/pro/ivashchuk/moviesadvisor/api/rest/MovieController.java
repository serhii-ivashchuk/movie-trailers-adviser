package pro.ivashchuk.moviesadvisor.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/movies", produces = "application/json")
public class MovieController {
}
