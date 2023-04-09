package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.dao.UnivercityRepository;
import ua.lviv.lgs.domain.Univercity;

@Controller
public class RatingController {

    @Autowired
    UnivercityRepository univercityRepository;


    @RequestMapping(value = "/increaseRating", method = RequestMethod.GET)
    public ModelAndView increaseRating(@RequestParam(name = "id") Integer universityId) {
        Univercity univercity = univercityRepository.findById(universityId).get();
        univercity.setRating(univercity.getRating()+0.01D);

        univercityRepository.updateRatingById(univercity.getRating(), universityId);

        return new ModelAndView("redirect:/universityPage?id="+universityId);
    }

    @RequestMapping(value = "/decreaseRating", method = RequestMethod.GET)
    public String decreaseRating(@RequestParam(name = "id") Integer universityId) {
        Univercity univercity = univercityRepository.findById(universityId).get();
        univercity.setRating(univercity.getRating()-0.01D);

        univercityRepository.updateRatingById(univercity.getRating(), universityId);

        return "redirect:/universityPage?id="+universityId;
    }
}


