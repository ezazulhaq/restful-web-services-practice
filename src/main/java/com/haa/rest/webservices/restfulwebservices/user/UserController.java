package com.haa.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    // Creats new user with response code - 200 OK
    @PostMapping(path = "/users-create")
    public void createUserOld(@RequestBody User user) {
        userService.saveUser(user);
    }

    // Best Practice - Create new user with correct response code - 201 Created
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User saveUser = userService.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
