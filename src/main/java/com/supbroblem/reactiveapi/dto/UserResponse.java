package com.supbroblem.reactiveapi.dto;

public record UserResponse(
        Integer id,
        String firstname,
        String lastname,
        Integer age,
        String email
) {
}
