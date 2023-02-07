package ua.lviv.lgs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
