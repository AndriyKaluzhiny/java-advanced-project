package ua.lviv.lgs.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.dao.SubjectRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Subject;
import ua.lviv.lgs.domain.User;

import java.io.IOException;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder bcryptpasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private SubjectRepository subjectRepository;


    Logger logger = LoggerFactory.getLogger(UserService.class);


    public void save(User user) throws IOException {
        logger.info("Save user to database");
        userRepository.save(user);
    }
}
