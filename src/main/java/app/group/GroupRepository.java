package app.group;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository <Group, String>{

    // getAllGroups()
    // addGroup(Group group)
    // updateGroup(String nameOfGroup, Group group)
    // deleteGroup(String nameOfGroup)

}