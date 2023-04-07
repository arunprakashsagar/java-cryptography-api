import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaCryptographyClient {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update("some text".getBytes());
        byte[] bytes = md.digest();
        System.out.println(new String(bytes));
       
    }
}
