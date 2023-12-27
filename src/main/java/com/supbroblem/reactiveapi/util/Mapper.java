package com.supbroblem.reactiveapi.util;

import com.supbroblem.reactiveapi.dto.UserRequest;
import com.supbroblem.reactiveapi.dto.UserResponse;
import com.supbroblem.reactiveapi.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class Mapper {

    public Mono<UserResponse> userToResponseDto(Mono<User> user) {
        return user.map(u -> new UserResponse(
                u.getId(),
                u.getFirstname(),
                u.getLastname(),
                u.getAge(),
                u.getEmail()
        ));
    }


    public User requestDtoToUser(UserRequest request) {
        return User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .age(request.age())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public Flux<UserResponse> responsesToList(Flux<User> users) {
        return users.flatMap(user -> userToResponseDto(Mono.just(user)));
    }

}
