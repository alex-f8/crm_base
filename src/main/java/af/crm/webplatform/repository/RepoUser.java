package af.crm.webplatform.repository;

import af.crm.webplatform.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoUser extends JpaRepository<User, Long> {

    List<User> findByFullName(String fullName);

    User findByEmail(String email);
}
