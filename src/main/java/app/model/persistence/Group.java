package app.model.persistence;

import app.model.dto.GroupDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private long groupID;

    @Column(name = "name_of_group")
    private String nameOfGroup;

    @ManyToMany
    @JoinTable(name="groups_users",
            joinColumns=@JoinColumn(name="group_id"),
            inverseJoinColumns=@JoinColumn(name="user_id"))
    private Set<User> usersFromGroup;

    Group(){}

    public Group(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Group(String nameOfGroup, Set<User> usersFromGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Group(GroupDTO groupDTO){
        this.nameOfGroup = groupDTO.getNameOfGroup();
        this.setUsersFromGroup(new HashSet<>());
    }

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Set<User> getUsersFromGroup() {
        return usersFromGroup;
    }

    public void setUsersFromGroup(Set<User> usersFromGroup) {
        this.usersFromGroup = usersFromGroup;
    }
}