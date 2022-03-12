package af.crm.webplatform.repository;

import af.crm.webplatform.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoClient extends JpaRepository<Client, Long> {
}
