package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Subject;

import java.util.List;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer>, JpaRepository<Faculty, Integer> {

    @Query(value = "select * from faculty where university_id=?", nativeQuery = true)
    List<Faculty> findAllByUniversityId(Integer id);
}
