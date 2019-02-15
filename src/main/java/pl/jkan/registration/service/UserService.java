package pl.jkan.registration.service;

import pl.jkan.registration.model.User;

public interface UserService {
    void save(User car);
    User findByUsername(String username);

}
