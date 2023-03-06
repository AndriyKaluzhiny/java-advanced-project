package ua.lviv.lgs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.dao.SubjectRepository;
import ua.lviv.lgs.dao.UnivercityRepository;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Subject;
import ua.lviv.lgs.domain.Univercity;

import java.util.HashSet;
import java.util.Set;

@Controller
public class FacultyController {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private UnivercityRepository univercityRepository;

    Logger logger = LoggerFactory.getLogger(FacultyController.class);

    @RequestMapping(value = "/addFaculty", method = RequestMethod.GET)
    public ModelAndView init(@RequestParam("universityId") Integer id,Model model) {
        ModelAndView mav = new ModelAndView("addFaculty");
        mav.addObject("data", univercityRepository.findById(id).get());

        return mav;
    }

    @RequestMapping(value = "/addFacultyProcessing", method = RequestMethod.GET)
    public ModelAndView save(@RequestParam("name") String names,
                             @RequestParam("minPoints") String minPoints, @RequestParam(name = "universityId") Integer id) {
        String[] namesArr = names.split(",");
        String[] minPointsArr = minPoints.split(",");


        for (int i = 0; i < namesArr.length; i++) {
            Faculty faculty = new Faculty();

            if (!namesArr[i].isEmpty()) {

                faculty.setName(namesArr[i].trim());
                faculty.setMinimalPoints(Integer.parseInt(minPointsArr[i].trim()));
                faculty.setUnivercity(univercityRepository.findById(id).get());

                logger.info("Save faculty" + faculty.toString());

                facultyRepository.save(faculty);
            }
        }


        return new ModelAndView("redirect:/universityPage?id=" + id);
    }

}
