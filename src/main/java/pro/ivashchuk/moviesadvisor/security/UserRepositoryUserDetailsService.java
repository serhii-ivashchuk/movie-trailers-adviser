package pro.ivashchuk.moviesadvisor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pro.ivashchuk.moviesadvisor.repository.JpaUserRepository;

@Service
public class UserRepositoryUserDetailsService implements UserDetails {

    JpaUserRepository jpaUserRepository;

    @Autowired
    public UserRepositoryUserDetailsService userRepositoryUserDetailsService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }
}
