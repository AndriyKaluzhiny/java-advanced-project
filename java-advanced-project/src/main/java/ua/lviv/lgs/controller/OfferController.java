package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.dao.OfferRepository;
import ua.lviv.lgs.dao.UnivercityRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Offer;
import ua.lviv.lgs.domain.Univercity;
import ua.lviv.lgs.domain.User;

import java.util.Set;

@Controller
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private UnivercityRepository univercityRepository;
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public ModelAndView offers(@RequestParam(name = "id") Integer id) {
        Univercity univercity = univercityRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("offers");
        modelAndView.addObject("offers", offerRepository.findByUniversityName(univercity.getName()));

        return modelAndView;
    }

    @RequestMapping(value = "/accept", method = RequestMethod.GET)
    public ModelAndView accept(@RequestParam("offerId") Integer id) {
        Offer offer = offerRepository.findById(id).get();
        User user = userRepository.findByEmail(offer.getEmail()).get();
        Univercity univercity = univercityRepository.findAllByName(offer.getUniversityName()).get();

        user.setUnivercities(Set.of(univercity));
        univercity.setCountOfStudents(univercity.getCountOfStudents()+1L);

        offerRepository.delete(offer);
        return new ModelAndView("redirect:/offers?id=" + univercity.getId());
    }

    @RequestMapping(value = "/deny", method = RequestMethod.GET)
    public ModelAndView deny(@RequestParam("offerId") Integer id) {
        Offer offer = offerRepository.findById(id).get();
        User user = userRepository.findByEmail(offer.getEmail()).get();
        Univercity univercity = univercityRepository.findAllByName(offer.getUniversityName()).get();

        offerRepository.delete(offer);
        return new ModelAndView("redirect:/offers?id=" + univercity.getId());
    }
}
