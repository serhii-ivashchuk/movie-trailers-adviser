package pro.ivashchuk.moviesadvisor.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pro.ivashchuk.moviesadvisor.repository.JpaUserRepository;

@Service
public class UserRepositoryUserDetailsService implements UserDetails {

    JpaUserRepository jpaUserRepository;
}
