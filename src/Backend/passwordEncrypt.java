package Backend;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passwordEncrypt {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public static boolean check(String password,String hash)
    {
        boolean matches = encoder.matches(password, hash);
        return matches;
    }

    public static String encrypt_password(String password)
    {
        String hashedPassword = encoder.encode(password);

        // Print the hashed password
        System.out.println("Hashed Password: " + hashedPassword);

        // return the hashed password
        return  hashedPassword;
    }

}
