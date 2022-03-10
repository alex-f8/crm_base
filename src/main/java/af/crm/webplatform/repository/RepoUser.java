package af.crm.webplatform.repository;

import af.crm.webplatform.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUser extends JpaRepository<User, Long> {
}
