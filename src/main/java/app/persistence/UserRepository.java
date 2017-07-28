package app.persistence;

import app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, String> {

    Set<User> findByUsersGroups(String nameOfGroup);

    // getAllUsers()
    // getAllUsersFromGroup() - we need our own method!
    // addUser(User user)
    // updateUser(String username, User user)
    // deleteUser(String username)

}