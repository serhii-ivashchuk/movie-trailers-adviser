package pro.ivashchuk.moviesadvisor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.moviesadvisor.domain.Actor;
import pro.ivashchuk.moviesadvisor.repository.JpaActorRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/actors")
public class ActorController {

    final static Logger log = LoggerFactory.getLogger(ActorController.class);

    private JpaActorRepository jpaActorRepository;

    @GetMapping
    public String getAllActors(Model model) {
        log.info("getAllActors() of ActorController is invoked");
        List<Actor> actors = new ArrayList<>(jpaActorRepository.findAll());
        model.addAttribute("actors", actors);
        return "All_actors";}

}
