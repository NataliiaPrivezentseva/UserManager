package app.logic;

import app.model.dto.UserDTO;
import app.model.persistence.Group;
import app.model.persistence.User;
import app.persistence.GroupRepository;
import app.persistence.UserRepository;
import app.web.serialization.DateDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private DateDeserializer dateDeserializer;

    public Set<User> getAllUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public Set<User> getAllUsersFromGroup(String nameOfGroup) {
        return groupRepository.findOneByNameOfGroup(nameOfGroup).getUsersFromGroup();
    }

    public User getUser(String username) {
        return userRepository.findOneByUsername(username);
    }

    public void addUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);

        Set<String> namesOfGroupsForUserDTO = userDTO.getGroupsOfUser();
        for (String s : namesOfGroupsForUserDTO) {
            Group group = groupRepository.findOneByNameOfGroup(s);
            if (group == null) {
                group = new Group(s);
                group.setUsersFromGroup(new HashSet<>());
            }
            group.getUsersFromGroup().add(user);
            groupRepository.save(group);
        }
    }

    public void changePassword(String username, String password) {
        User user = userRepository.findOneByUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }

    public void changeFirstName(String username, String firstName) {
        User user = userRepository.findOneByUsername(username);
        user.setFirstName(firstName);
        userRepository.save(user);
    }

    public void changeLastName(String username, String lastName) {
        User user = userRepository.findOneByUsername(username);
        user.setLastName(lastName);
        userRepository.save(user);
    }

    public void changeUsername(String username, String newUsername) {
        User user = userRepository.findOneByUsername(username);
        user.setUsername(newUsername);
        userRepository.save(user);
    }

    public void changeDateOfBirth(String username, String dateOfBirth) {
        User user = userRepository.findOneByUsername(username);
        user.setDateOfBirth(dateDeserializer.parseDate(dateOfBirth));
        userRepository.save(user);
    }

    public void addGroupToGroupsOfUser(String username, String nameOfGroup) {
        User user = userRepository.findOneByUsername(username);

        for (Group group : user.getGroupsOfUser()) {
            if (group.getNameOfGroup().equals(nameOfGroup)) {
                return;
            }
        }

        Group group = groupRepository.findOneByNameOfGroup(nameOfGroup);
        if (group == null) {
            group = new Group(nameOfGroup);
            user.getGroupsOfUser().add(group);
        } else {
            user.getGroupsOfUser().add(group);
        }
        userRepository.save(user);
    }

    public void addSeveralGroupsToGroupsOfUser(String username, List<String> namesOfGroups) {
        for (String nameOfGroup : namesOfGroups) {
            addGroupToGroupsOfUser(username, nameOfGroup);
        }
    }

    public void deleteGroupFromGroupsOfUser(String username, String nameOfGroup) {
        User user = userRepository.findOneByUsername(username);
        Set<Group> groupsOfUser = user.getGroupsOfUser();

        for (Iterator<Group> iter = groupsOfUser.iterator(); iter.hasNext(); ){
            Group group = iter.next();
            if (group.getNameOfGroup().equals(nameOfGroup)) {
                iter.remove();
                userRepository.save(user);
                return;
            }
        }
    }

    public void deleteSeveralGroupsFromGroupsOfUser(String username, List<String> namesOfGroups) {
        for (String nameOfGroup : namesOfGroups) {
            deleteGroupFromGroupsOfUser(username, nameOfGroup);
        }
    }

    public void deleteUser(String username) {
        User user = userRepository.findOneByUsername(username);
        userRepository.delete(user);
    }
}