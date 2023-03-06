package ua.lviv.lgs.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.dao.UnivercityRepository;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Univercity;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {

    @Autowired
    private UnivercityRepository univercityRepository;

    Logger logger = LoggerFactory.getLogger(UniversityService.class);

    public List<Univercity> readAll() {
        List<Univercity> universities = new ArrayList<>();

        univercityRepository.findAll().forEach(universities::add);
        logger.info("Get all universities");
        return universities;
    }

    public void save(@ModelAttribute(name = "university") Univercity univercity) {
        univercity.setRating(0.0);
        univercity.setCountOfStudents(0L);
        logger.info("Save university");
        univercityRepository.save(univercity);
    }

    public Univercity findById(Integer id) {

        logger.info("Find university with id=" + id);
        return univercityRepository.findById(id).get();
    }
}
