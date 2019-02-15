package pl.jkan.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pl.jkan.registration.service.SecurityService;
import pl.jkan.registration.service.UserService;
import pl.jkan.registration.validator.UserValidator;

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


}
