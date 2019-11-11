package pro.ivashchuk.moviesadvisor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.moviesadvisor.repository.JpaActorRepository;

@Controller
@RequestMapping("/actors")
public class ActorController {

    final static Logger log = LoggerFactory.getLogger(ActorController.class);

    private JpaActorRepository jpaActorRepository;
}
