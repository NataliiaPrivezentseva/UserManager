package app.logic;

import app.persistence.GroupRepository;
import app.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();
        groupRepository.findAll()
                .forEach(groups::add);
        return groups;
    }

    public Group getGroup(String nameOfGroup) {
        return groupRepository.findOne(nameOfGroup);
    }

    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    public void updateGroup(Group group) {
        groupRepository.save(group);
    }

    public void deleteGroup(String nameOfGroup) {
        groupRepository.delete(nameOfGroup);
    }
}

