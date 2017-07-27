package app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Group {

    @Id
    private String nameOfGroup;

    @ManyToMany
    private Set<User> usersFromGroup;

    public Group(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
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