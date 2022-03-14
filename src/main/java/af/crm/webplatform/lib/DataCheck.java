package af.crm.webplatform.lib;

import af.crm.webplatform.entities.Client;
import af.crm.webplatform.entities.User;

public class DataCheck {

    public static boolean checkReceiveClient(Client client) {
        boolean result = false;
        if (!client.getName().isEmpty()
                && !client.getSurname().isEmpty()
                && checkBirthDate(client.getBirthDate().toString())
                && checkGender(client.getGender())
                && checkEmail(client.getEmail())
                && checkPhone(client.getPhone())
        )
            result = true;
        return result;
    }

    public static boolean checkReceiveUser(User user) {
        boolean result = false;
        if (checkEmail(user.getEmail()))
            result = true;
        return result;
    }

    public static boolean checkBirthDate(String email) {
        // ! ! ! add code
        return true;
    }

    public static boolean checkGender(char gender) {
        // ! ! ! add code
        return true;
    }

    public static boolean checkEmail(String email) {
        // ! ! ! add code
        return true;
    }

    public static boolean checkPhone(String email) {
        // ! ! ! add code
        return true;
    }

}
