package app.persistence;

import app.model.persistence.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Set<User> findByGroupsOfUser(String nameOfGroup);
    User findOneByUsername(String username);
}