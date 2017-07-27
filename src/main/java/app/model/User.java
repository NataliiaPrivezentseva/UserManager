package app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private ZonedDateTime dateOfBirth;

    @ManyToMany(mappedBy = "usersFromGroup")
    private Set<Group> usersGroups;

    public User(String userName, String password, String firstName, String lastName, ZonedDateTime dateOfBirth) {
        this.username = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

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

    public ZonedDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(ZonedDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Group> getUsersGroups() {
        return usersGroups;
    }

    public void setUsersGroups(Set<Group> usersGroups) {
        this.usersGroups = usersGroups;
    }
}