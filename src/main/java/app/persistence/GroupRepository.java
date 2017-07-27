package app.persistence;

import app.model.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository <Group, String>{

    // getAllGroups()
    // addGroup(Group web)
    // updateGroup(String nameOfGroup, Group web)
    // deleteGroup(String nameOfGroup)

}