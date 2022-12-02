package ua.lviv.lgs.dao;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.lgs.domain.Applicant;

public interface ApplicantRepository extends CrudRepository<Applicant, Integer> {
}
