package ua.lviv.lgs.common;

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

    public List<Univercity> readAll() {
        List<Univercity> universities = new ArrayList<>();

        univercityRepository.findAll().forEach(universities::add);

        return universities;
    }

    public void save(@ModelAttribute(name = "university") Univercity univercity) {
        univercity.setRating(0.0);
        univercity.setCountOfStudents(0L);

        univercityRepository.save(univercity);
    }

    public Univercity findById(Integer id) {
        return univercityRepository.findById(id).get();
    }
}
