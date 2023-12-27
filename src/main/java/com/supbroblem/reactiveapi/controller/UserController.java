package com.supbroblem.reactiveapi.controller;


import com.supbroblem.reactiveapi.dto.UserRequest;
import com.supbroblem.reactiveapi.dto.UserResponse;
import com.supbroblem.reactiveapi.entity.User;
import com.supbroblem.reactiveapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private final UserService userService;

    @GetMapping
    public Flux<UserResponse> findAllUsers() {
        return userService.findAllUser();
    }

    @PostMapping
    public Mono<ResponseEntity<User>> addUser(@RequestBody UserRequest request) {
        return userService.addUser(request);
    }

    @GetMapping("/firstname")
    public Flux<UserResponse> findAllUserByFirstname(@RequestParam String firstname) {
        return userService.findAllUserByFirstname(firstname);
    }

    @GetMapping("/id")
    public Mono<UserResponse> findUserById(Integer id) {
        return userService.findUserById(id);
    }
}
