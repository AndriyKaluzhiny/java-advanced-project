package ua.lviv.lgs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
}
