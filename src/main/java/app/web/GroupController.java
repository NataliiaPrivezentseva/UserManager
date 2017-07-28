package app.web;

import app.logic.GroupService;
import app.model.Group;
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

    @RequestMapping("/groups")
    public Set<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

//    //уточнить путь
    @RequestMapping("/groupsByUser/{username}")
    public Set<Group> getAllUsersGroupsForUser(@PathVariable String username){
        return groupService.getAllUsersGroupsForUser(username);
    }

    @RequestMapping("/groups/{nameOfGroup}")
    public Group getGroup(@PathVariable String nameOfGroup){
        return groupService.getGroup(nameOfGroup);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/groups")
    public void addGroup(@RequestBody Group group){
        groupService.addGroup(group);
    }

    // как изменяем группу? Продумать методы
    @RequestMapping(method = RequestMethod.PUT, value = "/groups/{nameOfGroup}")
    public void updateGroup(@RequestBody Group group){
        groupService.updateGroup(group);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/groups/{nameOfGroup}")
    public void deleteGroup(@PathVariable String nameOfGroup){
        groupService.deleteGroup(nameOfGroup);
    }
}