package app.model.persistence;

import app.model.dto.GroupDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "name_of_group")
    private String nameOfGroup;

    @ManyToMany
    @JoinTable(name="groups_users",
            joinColumns=@JoinColumn(name="name_of_group"),
            inverseJoinColumns=@JoinColumn(name="username"))
    private Set<User> usersFromGroup;

    Group(){}

    public Group(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Group(String nameOfGroup, Set<User> usersFromGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Group(GroupDTO groupDTO){
        this.nameOfGroup = this.getNameOfGroup();
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