package com.supbroblem.reactiveapi.repository;

import com.supbroblem.reactiveapi.entity.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

    @Query("SELECT * FROM users WHERE LOWER(firstname) = LOWER(:firstname)")
    Flux<User> findAllByFirstnameIgnoreCase(@Param("firstname") String firstname);

    @Query("SELECT * FROM users")
    Flux<User> findAllUsers();

    @Query("SELECT * FROM users WHERE age = :age")
    Flux<User> findUsersByAge(@Param("age") Integer age);

    @Query("SELECT * FROM users WHERE id = :id")
    Mono<User> findUserById(@Param("id") Integer id);
}
