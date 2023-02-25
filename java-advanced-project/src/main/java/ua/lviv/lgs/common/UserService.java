package ua.lviv.lgs.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.dao.SubjectRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Roles;
import ua.lviv.lgs.domain.Subject;
import ua.lviv.lgs.domain.User;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder bcryptpasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private SubjectRepository subjectRepository;


    public void save(@ModelAttribute(name = "userForm") User user) {
        user.setPassword(bcryptpasswordEncoder.encode(user.getPassword()));
        Set<Roles> roles = new HashSet<>();
        Roles role = new Roles();

        role.setName("USER");
        roles.add(role);

        user.setRole(roles);
        userRepository.save(user);
    }

    public Integer findIdByUserName(@RequestParam("userName") String name) {
        Optional<User> userOptional = userRepository.findByEmail(name);
        User user = userOptional.get();

        return user.getId();
    }

    public List<Subject> getAll() {
        List<Subject> subjects = new ArrayList<>(subjectRepository.findAll());

        return subjects;
    }

    public void save(@ModelAttribute("markForm") Subject subject) {
        subject.setFaculties(null);
        subjectRepository.save(subject);
    }


}
