package com.haa.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/jpa/users")
    public List<UserModel> fetchAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/jpa/user/{id}")
    public EntityModel<UserModel> fetchOneUser(@PathVariable Integer id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("id - " + id);
        }

        EntityModel<UserModel> model = EntityModel.of(user.get());

        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).fetchAllUsers());

        model.add(linkBuilder.withRel("all-users"));

        return model;
    }

    // Creats new user with response code - 200 OK
    @PostMapping(path = "/jpa/users-create")
    public void createUserOld(@RequestBody UserModel user) {
        userRepository.save(user);
    }

    // Best Practice - Create new user with correct response code - 201 Created
    @PostMapping(path = "/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserModel user) {
        UserModel saveUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/jpa/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new UserNotFoundException("id - " + id);
        }
    }

}
