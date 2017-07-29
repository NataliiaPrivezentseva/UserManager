package app.logic;

import app.model.persistence.Group;
import app.persistence.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Set<Group> getAllGroups() {
        Set<Group> groups = new HashSet<>();
        groupRepository.findAll()
                .forEach(groups::add);
        return groups;
    }

    public Set<Group> getAllUsersGroupsForUser(String username){
        Set<Group> groups = new HashSet<>();
        groupRepository.findByUsersFromGroup(username)
                .forEach(groups::add);
        return groups;
    }

    public Group getGroup(String nameOfGroup) {
        return groupRepository.findOne(nameOfGroup);
    }

    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    public void updateGroup(Group group) {
        groupRepository.save(group);
    }

    public void deleteGroup(String nameOfGroup) {
        groupRepository.delete(nameOfGroup);
    }
}