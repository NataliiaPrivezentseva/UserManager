package app.model.dto;

import java.util.Date;
import java.util.Set;

public class UserDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    private Set<String> groupsOfUser;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<String>  getGroupsOfUser() {
        return groupsOfUser;
    }

    public void setGroupsOfUser(Set<String> groupsOfUser) {
        this.groupsOfUser = groupsOfUser;
    }
}