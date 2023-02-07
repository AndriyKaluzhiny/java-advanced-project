package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.lgs.common.UserService;
import ua.lviv.lgs.domain.User;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String registration  (Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }


    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public String registration(@ModelAttribute(name = "userForm") User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(user);
        return "redirect:/";
    }


}
