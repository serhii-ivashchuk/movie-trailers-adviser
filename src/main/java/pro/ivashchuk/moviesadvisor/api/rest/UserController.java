package pro.ivashchuk.moviesadvisor.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.ivashchuk.moviesadvisor.domain.User;
import pro.ivashchuk.moviesadvisor.repository.JpaUserRepository;

import java.util.List;

@RestController("RestUserController")
@RequestMapping(path = "/api/users", produces = "application/json")
@CrossOrigin(origins = "*")
public class UserController {
    private JpaUserRepository jpaUserRepository;

    public UserController(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return jpaUserRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public User getUserById(@PathVariable("id") Long id) {
        return jpaUserRepository.findById(id).get();
    }

    @PostMapping(path = "/addNewUser", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User addNewUser(@RequestBody User user) {
        return jpaUserRepository.save(user);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return jpaUserRepository.save(user);
    }

    @PatchMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User patchUser(@PathVariable("id") Long id, @RequestBody User patchUser) {
        User user = jpaUserRepository.findById(id).get();
        if (patchUser.getUsername() != null) {
            user.setUsername(patchUser.getUsername());
            //etc
        }

        return jpaUserRepository.save(user);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long id) {
        jpaUserRepository.deleteById(id);
    }
}
