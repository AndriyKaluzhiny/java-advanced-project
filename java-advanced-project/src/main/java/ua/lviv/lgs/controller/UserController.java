package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.common.UserDTOHelper;
import ua.lviv.lgs.common.UserService;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.User;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView setLang(@RequestParam("lang") String lang) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("lang", lang);

        return modelAndView;
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public ModelAndView registration(@RequestParam String lang) {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("lang", lang);

        return modelAndView;
    }

    @RequestMapping(value = "/sign-in_processing", method = RequestMethod.POST)
    public String registration(@RequestParam("email") String email,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("password") String password,
                               @RequestParam("file") MultipartFile file,
                               @RequestParam("lang") String lang) throws IOException {
        userService.save(UserDTOHelper.createUser(firstName, lastName, email, password, file));

        return "redirect:/?lang=" + lang;
    }
}
