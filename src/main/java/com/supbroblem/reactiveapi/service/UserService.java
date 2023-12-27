package com.supbroblem.reactiveapi.service;


import com.supbroblem.reactiveapi.dto.UserRequest;
import com.supbroblem.reactiveapi.dto.UserResponse;
import com.supbroblem.reactiveapi.entity.User;
import com.supbroblem.reactiveapi.repository.UserRepository;
import com.supbroblem.reactiveapi.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    public Flux<UserResponse> findAllUser() {

        var users = userRepository.findAllUsers();

        return mapper.responsesToList(users);

    }

    public Flux<UserResponse> findAllUserByFirstname(String firstname) {
        var users = userRepository.findAllByFirstnameIgnoreCase(firstname);

        return mapper.responsesToList(users);
    }

    public Mono<ResponseEntity<User>> addUser(UserRequest userRequest) {

        var user = mapper.requestDtoToUser(userRequest);

        return userRepository.save(user)
                .map(u -> ResponseEntity.status(HttpStatus.CREATED).body(u))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    public Flux<UserResponse> findUsersByAge(Integer age) {

        var users = userRepository.findUsersByAge(age);

        return mapper.responsesToList(users);

    }

    public Mono<UserResponse> findUserById(Integer id) {
        var user = userRepository.findUserById(id);

        return mapper.userToResponseDto(user);
    }
}
