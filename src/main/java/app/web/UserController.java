package app.web;

import app.logic.UserService;
import app.model.dto.UserDTO;
import app.model.persistence.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Api(tags = "Manager for users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

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

    @ApiOperation(value = "Get user by its username")
    @RequestMapping(method = RequestMethod.GET, value = "/users/{username}")
    public User getUser(@PathVariable String username){
        return userService.getUser(username);
    }

    @ApiOperation(value = "Add new user")
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
    }

    @ApiOperation(value = "Update user: change password")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{username}/changePassword")
    public void changePassword(@PathVariable String username, @RequestParam String password){
        userService.changePassword(username, password);
    }

    @ApiOperation(value = "Update user: change first name")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{username}/changeFirstName/{firstName}")
    public void changeFirstName(@PathVariable String username, @PathVariable String firstName){
        userService.changeFirstName(username, firstName);
    }

    @ApiOperation(value = "Update user: change last name")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{username}/changeLastName/{lastName}")
    public void changeLastName(@PathVariable String username, @PathVariable String lastName){
        userService.changeLastName(username, lastName);
    }

    @ApiOperation(value = "Update user: change username")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{username}/changeUserame/{newUsername}")
    public void changeUsername(@PathVariable String username, @PathVariable String newUsername){
        userService.changeUsername(username, newUsername);
    }

    @ApiOperation(value = "Update user: change date of birth")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{username}/changeDateOfBirth/{dateOfBirth}")
    public void changeDateOfBirth(@PathVariable String username, @PathVariable String dateOfBirth){
        userService.changeDateOfBirth(username, dateOfBirth);
    }

    @ApiOperation(value = "Update user: add one group to list of user's groups")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{username}/addGroupToGroupsOfUser/{nameOfGroup}")
    public void addGroupToGroupsOfUser(@PathVariable String username, @PathVariable String nameOfGroup){
        userService.addGroupToGroupsOfUser(username, nameOfGroup);
    }

    @ApiOperation(value = "Update user: add several groups to list of user's groups")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{username}/addSeveralGroupsToGroupsOfUser")
    public void addSeveralGroupsToGroupsOfUser(@PathVariable String username, @RequestParam List<String> namesOfGroups){
        userService.addSeveralGroupsToGroupsOfUser(username, namesOfGroups);
    }

    @ApiOperation(value = "Update user: delete one group from list of user's groups")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{username}/deleteGroupFromGroupsOfUser/{nameOfGroup}")
    public void deleteGroupFromGroupsOfUser(@PathVariable String username, @PathVariable String nameOfGroup){
        userService.deleteGroupFromGroupsOfUser(username, nameOfGroup);
    }

    @ApiOperation(value = "Update user: delete several groups from list of user's groups")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{username}/deleteSeveralGroupsFromGroupsOfUser")
    public void deleteSeveralGroupsFromGroupsOfUser(@PathVariable String username, @RequestParam List<String> namesOfGroups){
        userService.deleteSeveralGroupsFromGroupsOfUser(username, namesOfGroups);
    }

    @ApiOperation(value = "Delete user by its username")
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{username}")
    public void deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }
}