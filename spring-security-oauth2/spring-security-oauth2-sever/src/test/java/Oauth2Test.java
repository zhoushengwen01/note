import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Oauth2Test {
    public static void main(String[] args) {

        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
