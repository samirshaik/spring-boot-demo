package com.zenmonics.springboot.restservices.user;

import com.zenmonics.springboot.restservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/users/{id}")
    public Resource<User> getUser(@PathVariable int id) {
        User user = userService.findById(id);

        if (user == null) {
            throw new UserNotFoundException("User Not Found [" + id + "]");
        }

        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());

        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        User user = userService.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException("User Not Found [" + id + "]");
        }

        return ResponseEntity.noContent().build();
    }
}
