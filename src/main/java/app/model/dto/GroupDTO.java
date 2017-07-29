package app.model.dto;

import java.util.Set;

public class GroupDTO {

    private String nameOfGroup;

    private Set<String> usersFromGroup;

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Set<String> getUsersFromGroup() {
        return usersFromGroup;
    }

    public void setUsersFromGroup(Set<String> usersFromGroup) {
        this.usersFromGroup = usersFromGroup;
    }
}