package af.crm.webplatform.entities;

import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void getBirthDate() {
        Client client = new Client("A", "A", "2020-01-01", 'm', "A", "A");
        System.out.println(client.getBirthDate());
        assertEquals("2020-01-01", client.getBirthDate());
    }
}