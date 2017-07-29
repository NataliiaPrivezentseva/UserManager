package app.logic;

import app.model.dto.UserDTO;
import app.model.persistence.Group;
import app.model.persistence.User;
import app.persistence.GroupRepository;
import app.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
        Set<User> users = new HashSet<>();
        userRepository.findByGroupsOfUser(nameOfGroup)
                .forEach(users::add);
        return users;
    }

    public User getUser(String username) {
        return userRepository.findOne(username);
    }

    // метод не добавляет новую группу, если таковой не существовало
    public void addUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);

        System.out.println(user.toString());

        Iterable<Group> groupsOfUser = groupRepository.findAll(userDTO.getGroupsOfUser());
        for (Group group : groupsOfUser) {

            Iterable<Group> groups = groupRepository.findAll();
            Set<Group> existingGroups = new HashSet<>();
            for (Group group1 : groups) {
                existingGroups.add(group1);
            }

            if (!existingGroups.contains(group)){
                groupRepository.save(group);
            }

            group.getUsersFromGroup().add(user);
            user.getGroupsOfUser().add(group);
        }

        groupRepository.save(groupsOfUser);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String username) {
        userRepository.delete(username);
    }
}