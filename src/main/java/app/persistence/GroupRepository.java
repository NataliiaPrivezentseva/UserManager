package app.persistence;

import app.model.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface GroupRepository extends CrudRepository<Group, String> {

    // не понятно, как в этом методе обратиться к полю другого класса, при том, что класс еще и запихан в коллекцию
    Set<Group> findByUsersFromGroup(String username);

    // getAllGroups()
    // getAllUsersGroupsForUser(String username) - we need our own method!
    // addGroup(Group group)
    // updateGroup(String nameOfGroup, Group group)
    // deleteGroup(String nameOfGroup)

}