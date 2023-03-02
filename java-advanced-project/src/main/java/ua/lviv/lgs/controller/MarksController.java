package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.dao.*;
import ua.lviv.lgs.domain.*;

import java.util.HashSet;
import java.util.List;

@Controller
public class MarksController {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private UnivercityRepository univercityRepository;
    @Autowired
    private OfferRepository offerRepository;


    @RequestMapping(value = "/marks", method = RequestMethod.GET)
    public ModelAndView init(@RequestParam("userName") String username) {
        ModelAndView modelAndView = new ModelAndView("marks");
        User user = userRepository.findByEmail(username).get();
        modelAndView.addObject("marks", subjectRepository.findAllByUserId(user.getId()));

        return modelAndView;
    }

    @RequestMapping(value = "/registerMark", method = RequestMethod.GET)
    public ModelAndView initializeModel(Model model) {
        return new ModelAndView("registerMark", "markForm", new Subject());
    }



    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ModelAndView save(@RequestParam("name") String name,
                             @RequestParam("points") Integer points,
                             @RequestParam("userName") String userName) throws Exception {

        User user = userRepository.findByEmail(userName).get();

        Subject subject = new Subject();
        subject.setUserId(user);
        subject.setName(name);
        subject.setPoints(points);

        subjectRepository.save(subject);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/sendMarks", method = RequestMethod.GET)
    public ModelAndView sendMarks(@RequestParam("email") String email,
                                  @RequestParam("facultyId") Integer Fid) {
        Offer offer = new Offer();
        User user = userRepository.findByEmail(email).get();
        Faculty faculty = facultyRepository.findById(Fid).get();
        Univercity univercity = faculty.getUnivercity();

        offer.setUserName(user.getFirstName());
        offer.setEmail(user.getEmail());
        offer.setUniversityName(univercity.getName());

        Integer summary = 0;

        List<Subject> subjectList = user.getSubjects();

        for (Subject s : subjectList) {
            summary+=s.getPoints();
        }

        offer.setSummary(summary);

        offerRepository.save(offer);

        return new ModelAndView("redirect:/universityPage?id=" + univercity.getId());
    }
}
