package app.web;

import app.logic.GroupService;
import app.model.dto.GroupDTO;
import app.model.persistence.Group;
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

@Api(tags = "Manager for groups")
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @ApiOperation(value = "Get list of all groups")
    @RequestMapping(method = RequestMethod.GET, value = "/groups")
    public Set<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @ApiOperation(value = "Get list of groups for specified username")
    @RequestMapping(method = RequestMethod.GET, value = "/groupsByUser/{username}")
    public Set<Group> getAllUsersGroupsForUser(@PathVariable String username){
        return groupService.getAllUsersGroupsForUser(username);
    }

    @ApiOperation(value = "Get group by its name")
    @RequestMapping(method = RequestMethod.GET, value = "/groups/{nameOfGroup}")
    public Group getGroup(@PathVariable String nameOfGroup){
        return groupService.getGroup(nameOfGroup);
    }

    @ApiOperation(value = "Add new group")
    @RequestMapping(method = RequestMethod.POST, value = "/groups")
    public void addGroup(@RequestBody GroupDTO groupDTO){
        groupService.addGroup(groupDTO);
    }

    @ApiOperation(value = "Update group: change name of group")
    @RequestMapping(method = RequestMethod.PUT, value = "/groups/{nameOfGroup}/changeNameOfGroup/{newNameOfGroup}")
    public void changeNameOfGroup(@PathVariable String nameOfGroup, @PathVariable String newNameOfGroup){
        groupService.changeNameOfGroup(nameOfGroup, newNameOfGroup);
    }

    @ApiOperation(value = "Update group: add one user to group")
    @RequestMapping(method = RequestMethod.PUT, value = "/groups/{nameOfGroup}/addUserToGroup/{username}")
    public void addUserToGroup(@PathVariable String nameOfGroup, @PathVariable String username){
        groupService.addUserToGroup(nameOfGroup, username);
    }

    @ApiOperation(value = "Update group: add several users to group")
    @RequestMapping(method = RequestMethod.PUT, value = "/groups/{nameOfGroup}/addSeveralUsersToGroup")
    public void addSeveralUsersToGroup(@PathVariable String nameOfGroup, @RequestParam List<String> usernames){
        groupService.addSeveralUsersToGroup(nameOfGroup, usernames);
    }

    @ApiOperation(value = "Update group: delete one user from group")
    @RequestMapping(method = RequestMethod.PUT, value = "/groups/{nameOfGroup}/deleteUserFromGroup/{username}")
    public void deleteUserFromGroup(@PathVariable String nameOfGroup, @PathVariable String username){
        groupService.deleteUserFromGroup(nameOfGroup, username);
    }

    @ApiOperation(value = "Update group: delete several users from group")
    @RequestMapping(method = RequestMethod.PUT, value = "/groups/{nameOfGroup}/deleteSeveralUsersToGroup")
    public void deleteSeveralUsersFromGroup(@PathVariable String nameOfGroup, @RequestParam List<String> usernames){
        groupService.deleteSeveralUsersFromGroup(nameOfGroup, usernames);
    }

    @ApiOperation(value = "Delete group by its name")
    @RequestMapping(method = RequestMethod.DELETE, value = "/groups/{nameOfGroup}")
    public void deleteGroup(@PathVariable String nameOfGroup){
        groupService.deleteGroup(nameOfGroup);
    }
}