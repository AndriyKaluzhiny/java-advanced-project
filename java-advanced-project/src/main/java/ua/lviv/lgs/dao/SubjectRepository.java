package ua.lviv.lgs.dao;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.lgs.domain.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
