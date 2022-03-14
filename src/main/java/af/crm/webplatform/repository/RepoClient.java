package af.crm.webplatform.repository;

import af.crm.webplatform.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoClient extends JpaRepository<Client, Long> {
    List<Client> findByName(String name);

    List<Client> findBySurname(String surname);

    List<Client> findByGender(char gender);

    // List<Client> findByAge(char age);

    Client findByEmail(String email);

    Client findByPhone(String phone);
}
