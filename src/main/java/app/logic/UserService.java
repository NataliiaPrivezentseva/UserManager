package app.logic;

import app.model.dto.UserDTO;
import app.model.persistence.Group;
import app.model.persistence.User;
import app.persistence.GroupRepository;
import app.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    public Set<User> getAllUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public Set<User> getAllUsersFromGroup(String nameOfGroup) {
        return groupRepository.findOne(nameOfGroup).getUsersFromGroup();
    }

    public User getUser(String username) {
        return userRepository.findOne(username);
    }

    public void addUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);

        List<String> namesOfGroupsForUserDTO = userDTO.getGroupsOfUser();
        for (String s : namesOfGroupsForUserDTO) {
            Group group = groupRepository.findOne(s);
            if (group == null) {
                group = new Group(s);
                group.setUsersFromGroup(new HashSet<>());
            }
            group.getUsersFromGroup().add(user);
            groupRepository.save(group);
        }
    }

    public void changePassword(String username, String password){
        User user = userRepository.findOne(username);
        user.setPassword(password);
        userRepository.save(user);
    }

    public void changeFirstName(String username, String firstName) {
        User user = userRepository.findOne(username);
        user.setFirstName(firstName);
        userRepository.save(user);
    }

    public void changeLastName(String username, String lastName) {
        User user = userRepository.findOne(username);
        user.setLastName(lastName);
        userRepository.save(user);
    }

    // do not work
    public void changeUsername(String username, String newUsername) {
        User user = userRepository.findOne(username);
        user.setUsername(newUsername);
        userRepository.save(user);
    }

    public void deleteUser(String username) {
        userRepository.delete(username);
    }
}