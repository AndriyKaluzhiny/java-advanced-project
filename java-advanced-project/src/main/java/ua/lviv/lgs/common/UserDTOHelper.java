package ua.lviv.lgs.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.User;

import java.io.IOException;
import java.util.Base64;

public class UserDTOHelper {
    public static User createUser(String firstName, String lastName, String email, String password, MultipartFile file) throws IOException {
        User user = new User();
        PasswordEncoder BCryptPasswordEncroder = new BCryptPasswordEncoder();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(BCryptPasswordEncroder.encode(password));
        user.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
        user.setRole(Role.ADMIN);

        return user;
    }
}
