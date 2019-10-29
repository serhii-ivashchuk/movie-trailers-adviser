package pro.ivashchuk.moviesadvisor.domain;

        import org.springframework.security.core.GrantedAuthority;
        import org.springframework.security.core.authority.SimpleGrantedAuthority;
        import org.springframework.security.core.userdetails.UserDetails;

        import javax.persistence.*;
        import javax.validation.constraints.NotBlank;
        import java.util.Arrays;
        import java.util.Collection;

@Entity
@Table(name="Users")
public class User implements UserDetails
{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message="User Name is required")
    private String username;

    @NotBlank(message="Password is required")
    private String password;

    @NotBlank(message="Phrase is required")
    private String phrase;


    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User() {
    }

    public User(String username, String password, String phrase) {
        this.username = username;
        this.password = password;
        this.phrase = phrase;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User id[ username='%s', user password='%s', user phrase='%s']",
                username, password, phrase);
    }
}
