package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.domain.Univercity;

import java.util.Optional;

@Repository
public interface UnivercityRepository extends CrudRepository<Univercity, Integer> {
    @Transactional
    @Modifying
    @Query("update Univercity u set u.rating = ?1 where u.id = ?2")
    int updateRatingById(Double rating, Integer id);
    Optional<Univercity> findAllByName(String name);
}
