package ua.lviv.lgs.dao;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.lgs.common.UniversityService;
import ua.lviv.lgs.domain.Offer;
import ua.lviv.lgs.domain.Univercity;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer, Integer> {
    List<Offer> findByUniversityName(String universityName);

}
