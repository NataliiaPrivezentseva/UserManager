package app.web;

import app.logic.UserService;
import app.model.dto.UserDTO;
import app.model.persistence.User;
import io.swagger.annotations.ApiOperation;
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

    // работает
    @ApiOperation(value = "Get list of all users")
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public Set<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Get list of users for specified group")
    @RequestMapping(method = RequestMethod.GET, value = "/usersByGroup/{nameOfGroup}")
    public Set<User> getAllUsersFromGroup(@PathVariable String nameOfGroup){
        return userService.getAllUsersFromGroup(nameOfGroup);
    }

    // работает
    @ApiOperation(value = "Get user by its username")
    @RequestMapping(method = RequestMethod.GET, value = "/users/{username}")
    public User getUser(@PathVariable String username){
        return userService.getUser(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody UserDTO userDTO){
        //todo как создаем юзера и группы?
        userService.addUser(userDTO);
    }

//    // как изменяем юзера? Продумать методы
//    // сначала получить юзера методом getUser(@PathVariable String username), а потом заменить его на другого юзера
//    // тогда это будет метод replaceUser(@RequestBody User user, @RequestBody String nameOfGroup)
//    @RequestMapping(method = RequestMethod.PUT, value = "/users/{username}")
//    public void updateUser(@RequestBody User user, @RequestBody String nameOfGroup){
//        //todo передать список групп для юзера
//        user.setGroupsOfUser());
//        userService.updateUser(user);
//    }

    @ApiOperation(value = "Delete user by its username")
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{username}")
    public void deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }
}