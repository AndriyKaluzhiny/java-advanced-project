package ua.lviv.lgs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.Univercity;

import java.util.Optional;

@Repository
public interface UnivercityRepository extends CrudRepository<Univercity, Integer> {
    Optional<Univercity> findAllByName(String name);
}
