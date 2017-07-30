package app.model.persistence;

import app.model.dto.UserDTO;
import app.web.serialization.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userID;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date dateOfBirth;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinTable(name = "groups_users",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "name_of_group", referencedColumnName = "name_of_group"))
    private Set<Group> groupsOfUser;

    User() {
    }

    public User(String userName, String password, String firstName, String lastName,
                Date dateOfBirth, Set<Group> groupsOfUser) {
        this.username = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.groupsOfUser = groupsOfUser;
    }

    public User(UserDTO userDTO) {
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.dateOfBirth = userDTO.getDateOfBirth();
        this.groupsOfUser = new HashSet<>();
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Group> getGroupsOfUser() {
        return groupsOfUser;
    }

    public void setGroupsOfUser(Set<Group> groupsOfUser) {
        this.groupsOfUser = groupsOfUser;
    }

    @Override
    public String toString() {
        return "username = " + username + "\n" +
                "password = " + password + "\n" +
                "first name = " + firstName + "\n" +
                "last name = " + lastName + "\n" +
                "groups of user = " + groupsOfUser + "\n" +
                "date of birth = " + dateOfBirth;
    }
}