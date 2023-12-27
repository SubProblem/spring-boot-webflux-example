package com.supbroblem.reactiveapi.dto;

public record UserRequest(
        String firstname,
        String lastname,
        Integer age,
        String email,
        String password
) {
}
