package pl.jkan.registration.repository;

import org.springframework.data.repository.CrudRepository;
import pl.jkan.registration.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
