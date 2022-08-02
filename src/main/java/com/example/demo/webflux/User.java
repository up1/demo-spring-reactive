package com.example.demo.webflux;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
}
