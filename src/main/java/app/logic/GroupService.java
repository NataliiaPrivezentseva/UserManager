package app.logic;

import app.model.dto.GroupDTO;
import app.model.persistence.Group;
import app.model.persistence.User;
import app.persistence.GroupRepository;
import app.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    public Set<Group> getAllGroups() {
        Set<Group> groups = new HashSet<>();
        groupRepository.findAll()
                .forEach(groups::add);
        return groups;
    }

    public Set<Group> getAllUsersGroupsForUser(String username) {
        return userRepository.findOneByUsername(username).getGroupsOfUser();
    }

    public Group getGroup(String nameOfGroup) {
        return groupRepository.findOneByNameOfGroup(nameOfGroup);
    }

    public void addGroup(GroupDTO groupDTO) {
        Group group = new Group(groupDTO);
        Set<String> usernamesFromGroup = groupDTO.getUsersFromGroup();
        for (String s : usernamesFromGroup) {
            User user = userRepository.findOneByUsername(s);
            if (user == null) {
                user = new User(s);
                userRepository.save(user);
            }
            group.getUsersFromGroup().add(user);
        }
        groupRepository.save(group);
    }

    public void changeNameOfGroup(String nameOfGroup, String newNameOfGroup) {
        Group group = groupRepository.findOneByNameOfGroup(nameOfGroup);
        group.setNameOfGroup(newNameOfGroup);
        groupRepository.save(group);
    }

    public void addUserToGroup(String nameOfGroup, String username) {
        Group group = groupRepository.findOneByNameOfGroup(nameOfGroup);

        for (User userFromGroup : group.getUsersFromGroup()) {
            if (userFromGroup.getUsername().equals(username)) {
                return;
            }
        }

        User user = userRepository.findOneByUsername(username);
        if (user == null) {
            user = new User(username);
            userRepository.save(user);
        }
        group.getUsersFromGroup().add(user);
        groupRepository.save(group);
    }

    public void addSeveralUsersToGroup(String nameOfGroup, List<String> usernames){
        for (String username : usernames) {
            addUserToGroup(nameOfGroup, username);
        }
    }

    public void deleteUserFromGroup(String nameOfGroup, String username) {
        Group group = groupRepository.findOneByNameOfGroup(nameOfGroup);
        Set<User> usersFromGroup = group.getUsersFromGroup();
        for (Iterator<User> iter = usersFromGroup.iterator(); iter.hasNext(); ) {
            User user = iter.next();
            if (user.getUsername().equals(username)){
                iter.remove();
                groupRepository.save(group);
                return;
            }
        }
    }

    public void deleteSeveralUsersFromGroup(String nameOfGroup, List<String> usernames){
        for (String username : usernames) {
            deleteUserFromGroup(nameOfGroup, username);
        }
    }

    public void deleteGroup(String nameOfGroup) {
        Group group = groupRepository.findOneByNameOfGroup(nameOfGroup);
        groupRepository.delete(group);
    }
}