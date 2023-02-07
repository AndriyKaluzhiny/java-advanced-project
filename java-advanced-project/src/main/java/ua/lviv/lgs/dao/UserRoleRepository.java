package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.Roles;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<Roles, Integer> {
    @Query(value = "select a.name from user_roles a, user b where b.email=?1 and a.user_id=b.id", nativeQuery = true)
    List<String> findRoleByUserName(String userName);
}
