package pro.ivashchuk.moviesadvisor.controller;

        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import pro.ivashchuk.moviesadvisor.repository.JpaUserRepository;
        import pro.ivashchuk.moviesadvisor.security.UserRegistrationForm;

        import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    final static Logger log = LoggerFactory.getLogger(UserRegistrationController.class);

    private JpaUserRepository jpaUserRepository;
    private PasswordEncoder passwordEncoder;


    public UserRegistrationController(JpaUserRepository jpaUserRepository, PasswordEncoder passwordEncoder) {
        this.jpaUserRepository = jpaUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String userRegistration(Model model) {
        model.addAttribute("user", new UserRegistrationForm());
        log.info("userRegistration() of UserRegistrationController is invoked");
        return "Add_New_User";
    }

    @PostMapping("/registration")
    public String processNewUser(@Valid UserRegistrationForm user) {
        jpaUserRepository.save(user.toUser(passwordEncoder));
        log.info("processNewUser of UserRegistrationController is invoked");
        log.info("User: " + user);
        return "redirect:/";
    }
}
