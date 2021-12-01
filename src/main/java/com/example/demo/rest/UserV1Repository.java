package com.example.demo.rest;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserV1Repository {

    static Map<String, User> userData;
    static {
        userData = new HashMap<>();
        userData.put("1", new User("1", "User 1"));
        userData.put("2", new User("2", "Employee 2"));
        userData.put("3", new User("3", "Employee 3"));
        userData.put("4", new User("4", "Employee 4"));
        userData.put("5", new User("5", "Employee 5"));
    };

    public User findUserById(String id) {
        return userData.get(id);
    }

    public Collection<User> findAllUsers() {
        return userData.values();
    }
}
