package af.crm.webplatform.entities;

import org.junit.Assert;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class UserFrontTest {

    @org.junit.jupiter.api.Test
    void setFrontUser() throws NoSuchAlgorithmException {
        User user = new User("full name", "email@email.com", "password");
        UserFront userFront = new UserFront();
        assertEquals(new UserFront("full name", "email@email.com").toString() , userFront.setFrontUser(user));

    }
}