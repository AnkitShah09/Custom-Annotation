package com.example.custom_annotation.controller;

import com.example.custom_annotation.annotations.LogTime;
import com.example.custom_annotation.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    List<User> users = new ArrayList<>(
            List.of(
                    new User(1, "A"),
                    new User(2, "B"),
                    new User(3, "C"),
                    new User(4, "D"),
                    new User(5, "E")
            )
    );

    @GetMapping
    @LogTime
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    @LogTime
    public Optional<User> getUser(@PathVariable("id") Integer id) {
        return users.stream()
                .filter(user -> Objects.equals(id, user.id()))
                .findFirst();

    }
}
