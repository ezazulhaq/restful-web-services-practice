package com.haa.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public List<UserModel> fetchAllUsers() {
        return userService.findUserAll();
    }

    @GetMapping(path = "/user/{id}")
    public UserModel fetchOneUser(@PathVariable Integer id) {
        UserModel user = userService.findUserOne(id);
        if (user == null) {
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }

    // Creats new user with response code - 200 OK
    @PostMapping(path = "/users-create")
    public void createUserOld(@RequestBody UserModel user) {
        userService.saveUser(user);
    }

    // Best Practice - Create new user with correct response code - 201 Created
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody UserModel user) {
        UserModel saveUser = userService.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        UserModel user = userService.deleteUser(id);

        if (user == null)
            throw new UserNotFoundException("id - " + id);
    }

}
