package ua.lviv.lgs.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.dao.UserRoleRepository;
import ua.lviv.lgs.domain.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder bcryptpasswordEncoder = new BCryptPasswordEncoder();

    public void save(@ModelAttribute(name = "userForm") User user) {
        user.setPassword(bcryptpasswordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
    }
}
