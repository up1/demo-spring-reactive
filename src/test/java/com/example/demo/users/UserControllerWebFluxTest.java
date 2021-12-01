package com.example.demo.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = UserController.class)
public class UserControllerWebFluxTest {

    @MockBean
    private UserRepository repository;

    @Autowired
    private WebTestClient client;

    @BeforeEach
    public void initData() {
        List<User> list = new ArrayList<User>();
        list.add(new User("1", "name 1"));
        list.add(new User("2", "name 2"));
        list.add(new User("3", "name 3"));
        list.add(new User("4", "name 4"));
        list.add(new User("5", "name 5"));

        Flux<User> employeeFlux = Flux.fromIterable(list);

        when(repository.findAllUsers())
            .thenReturn(employeeFlux);
    }

    @Test
    public void getUserById() {
        WebTestClient.ListBodySpec<User> result = client.get().uri("/users/v2")
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class);

        List<User> users = result.returnResult().getResponseBody();
        assertEquals(5, users.size());
    }
}