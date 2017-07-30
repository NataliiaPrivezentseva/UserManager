package app.persistence;

import app.model.persistence.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    Set<Group> findByUsersFromGroup(String username);
    Group findOneByNameOfGroup(String nameOfGroup);
}