package ua.lviv.lgs.dao;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.lgs.domain.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
}
