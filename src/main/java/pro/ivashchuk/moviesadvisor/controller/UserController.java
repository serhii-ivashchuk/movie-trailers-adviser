package pro.ivashchuk.moviesadvisor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.moviesadvisor.domain.User;
import pro.ivashchuk.moviesadvisor.repository.JpaUserRepository;
import pro.ivashchuk.moviesadvisor.security.UserRegistrationForm;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    final static Logger log = LoggerFactory.getLogger(UserController.class);

    private final JpaUserRepository jpaUserRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(JpaUserRepository jpaUserRepository, PasswordEncoder passwordEncoder) {
        this.jpaUserRepository = jpaUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = jpaUserRepository.findAll();
        model.addAttribute("users", users);
        return "All_Users";
    }

    @GetMapping("/registration")
    public String addNewUser(Model model) {
        model.addAttribute("user", new UserRegistrationForm());
        log.info("userRegistration() of UserRegistrationController is invoked");
        return "Add_New_User";
    }

    @PostMapping("/registration")
    public String processNewUser(@Valid UserRegistrationForm user) {
        jpaUserRepository.save(user.toUser(passwordEncoder));
        log.info("processNewUser of UserRegistrationController is invoked");
        log.info("User: " + user);
        return "redirect:/login";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        User user = jpaUserRepository.findById(id).get();
        model.addAttribute("user", user);
        return "User";
    }

    @GetMapping("/user/{id}/change")
    public String updateUserById(@PathVariable("id") Long id, Model model){

        return "User";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        jpaUserRepository.delete(jpaUserRepository.findById(id).get());
        return "redirect:/users";
    }
}
