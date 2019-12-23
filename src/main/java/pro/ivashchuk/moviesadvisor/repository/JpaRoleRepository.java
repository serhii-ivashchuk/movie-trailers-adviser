package pro.ivashchuk.moviesadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.ivashchuk.moviesadvisor.domain.Role;

@Repository("roleRepository")
public interface JpaRoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
