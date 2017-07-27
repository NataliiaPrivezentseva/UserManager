package app.web;

import app.logic.UserService;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // уточнить, что после слеша, может, тут только "/users"
    @RequestMapping("/groups/{nameOfGroup}/users")
    public Set<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //уточнить путь
    @RequestMapping("/groups/{nameOfGroup}/users")
    public Set<User> getAllUsersFromGroup(String nameOfGroup){
        return userService.getAllUsersFromGroup(nameOfGroup);
    }

    @RequestMapping("/groups/{nameOfGroup}/users/{username}")
    public User getUser(@PathVariable String username){
        return userService.getUser(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/groups/{nameOfGroup}/users")
    public void addUser(@RequestBody User user, @RequestBody String nameOfGroup){
        //todo передать список групп для юзера
        user.setUsersGroups());
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/groups/{nameOfGroup}/users/{username}")
    public void updateUser(@RequestBody User user, @RequestBody String nameOfGroup){
        //todo передать список групп для юзера
        user.setUsersGroups());
        userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/groups/{nameOfGroup}/users/{username}")
    public void deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }
}