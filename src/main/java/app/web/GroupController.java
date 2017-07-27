package app.web;

import app.logic.GroupService;
import app.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping("/groups")
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @RequestMapping("/groups/{nameOfGroup}")
    public Group getGroup(@PathVariable String nameOfGroup){
        return groupService.getGroup(nameOfGroup);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/groups")
    public void addGroup(@RequestBody Group group){
        groupService.addGroup(group);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/groups/{nameOfGroup}")
    public void updateGroup(@RequestBody Group group){
        groupService.updateGroup(group);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/groups/{nameOfGroup}")
    public void deleteGroup(@PathVariable String nameOfGroup){
        groupService.deleteGroup(nameOfGroup);
    }
}