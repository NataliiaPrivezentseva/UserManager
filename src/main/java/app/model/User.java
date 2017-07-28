package app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
//    private ZonedDateTime dateOfBirth;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "groups_users",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "name_of_group", referencedColumnName = "name_of_group"))
    private Set<Group> usersGroups;

    User(){
    }

    public User(String userName, String password, String firstName, String lastName) {
        this.username = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // конструктор с датой
//    public User(String userName, String password, String firstName, String lastName, ZonedDateTime dateOfBirth) {
//        this.username = userName;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = dateOfBirth;
//    }

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

//    public ZonedDateTime getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(ZonedDateTime dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }

    public Set<Group> getUsersGroups() {
        return usersGroups;
    }

    public void setUsersGroups(Set<Group> usersGroups) {
        this.usersGroups = usersGroups;
    }
}