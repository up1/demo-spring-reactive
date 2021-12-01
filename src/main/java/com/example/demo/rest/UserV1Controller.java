package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/users/v1")
public class UserV1Controller {

    private final UserV1Repository userV1Repository;

    public UserV1Controller(UserV1Repository userV1Repository) {
        this.userV1Repository = userV1Repository;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return this.userV1Repository.findUserById(id);
    }

    @GetMapping
    private Collection<User> getAllEmployees() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.userV1Repository.findAllUsers();
    }

}
