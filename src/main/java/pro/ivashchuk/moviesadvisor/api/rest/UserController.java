package pro.ivashchuk.moviesadvisor.api.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.ivashchuk.moviesadvisor.domain.User;
import pro.ivashchuk.moviesadvisor.repository.JpaUserRepository;

import java.util.List;

@RestController
@RequestMapping(path="/api/users", produces = "application/json")
@CrossOrigin(origins = "*")
public class UserController {
    private JpaUserRepository jpaUserRepository;

    public UserController(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @GetMapping
    public List<User> getAllUsers(){
       return jpaUserRepository.findAll();
    }

    @GetMapping("/registration")
    public String addNewUser() {
        return "";
    }
}
