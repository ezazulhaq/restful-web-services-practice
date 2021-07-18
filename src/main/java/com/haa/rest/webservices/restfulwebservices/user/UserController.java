package com.haa.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(path = "/users")
    public List<User> fetchAllUsers() {
        return userService.findUserAll();
    }

    @GetMapping(path = "/user/{id}")
    public User fetchOneUser(@PathVariable Integer id) {
        return userService.findUserOne(id);
    }

    @PostMapping(path = "/users")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

}
