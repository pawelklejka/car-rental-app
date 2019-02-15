package pl.jkan.registration.repository;

import org.springframework.data.repository.CrudRepository;
import pl.jkan.registration.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
