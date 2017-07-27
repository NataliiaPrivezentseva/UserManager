package app.logic;

import app.model.User;
import app.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Set<User> getAllUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public Set<User> getAllUsersFromGroup(String nameOfGroup) {
        Set<User> users = new HashSet<>();
        userRepository.findByGroupNameOfGroup(nameOfGroup)
                .forEach(users::add);
        return users;
    }

    public User getUser(String username) {
        return userRepository.findOne(username);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String username) {
        userRepository.delete(username);
    }
}