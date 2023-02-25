package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.Subject;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    List<Subject> findAll();

    @Query(value = "select * from subject s where s.user=?", nativeQuery = true)
    List<Subject> findAllByUserId(Integer id);


}
