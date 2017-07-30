package app.logic;

import app.model.dto.GroupDTO;
import app.model.persistence.Group;
import app.model.persistence.User;
import app.persistence.GroupRepository;
import app.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
        User user = userRepository.findOneByUsername(username);
        if (user == null) {
            user = new User(username);
            userRepository.save(user);
        }
        group.getUsersFromGroup().add(user);
        groupRepository.save(group);
    }

    public void deleteUserFromGroup(String nameOfGroup, String username) {
        Group group = groupRepository.findOneByNameOfGroup(nameOfGroup);
        Set<User> usersFromGroup = group.getUsersFromGroup();
        for (User user : usersFromGroup) {
            if (user.getUsername().equals(username)){
                group.getUsersFromGroup().remove(user);
            }
        }
        groupRepository.save(group);
    }

    public void deleteGroup(String nameOfGroup) {
        Group group = groupRepository.findOneByNameOfGroup(nameOfGroup);
        groupRepository.delete(group);
    }
}