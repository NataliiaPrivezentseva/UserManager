package app.persistence;

import app.model.persistence.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GroupRepository extends CrudRepository<Group, String> {

    Set<Group> findByUsersFromGroup(String username);
}