package com.example.demo.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users/v2")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable String id) {
        return this.userRepository.findUserById(id);
    }

    @GetMapping
    public Flux<User> getAllEmployees() {
//        return this.userRepository.findAllUsers().delayElements(Duration.ofSeconds(3));
        return this.userRepository.findAllUsers();
    }

}
