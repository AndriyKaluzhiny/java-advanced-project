package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.common.UserService;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.User;

import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration");
    }


    @RequestMapping(value = "/sign-in_processing", method = RequestMethod.POST)
    public String registration(@RequestParam("email") String email,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("password") String password,
                               @RequestParam("file") MultipartFile file) throws IOException {
        userService.save(email, firstName, lastName, password, file);

        return "redirect:/";
    }

    @RequestMapping(value = "/security_check", method = RequestMethod.POST)
    public ModelAndView directToUserProfile(@RequestParam("userName") String userName) {
        ModelAndView modelAndView = new ModelAndView("cabinet");

        modelAndView.addObject("currentUser", userRepository.findByEmail(userName).get());
        System.out.println(userRepository.findByEmail(userName).get().toString() + 123);

        return modelAndView;
    }




}
