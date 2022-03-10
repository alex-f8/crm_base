package af.crm.webplatform.lib;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
    public static String sha1(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.reset();
        messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
        return DatatypeConverter.printHexBinary(messageDigest.digest());
    }
}
