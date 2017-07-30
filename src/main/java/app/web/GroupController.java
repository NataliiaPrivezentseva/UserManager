package app.web;

import app.logic.GroupService;
import app.model.dto.GroupDTO;
import app.model.persistence.Group;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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

    // как изменяем группу? Продумать методы
    @RequestMapping(method = RequestMethod.PUT, value = "/groups/{nameOfGroup}")
    public void updateGroup(@RequestBody Group group){
        groupService.updateGroup(group);
    }

    @ApiOperation(value = "Delete group by its name")
    @RequestMapping(method = RequestMethod.DELETE, value = "/groups/{nameOfGroup}")
    public void deleteGroup(@PathVariable String nameOfGroup){
        groupService.deleteGroup(nameOfGroup);
    }
}