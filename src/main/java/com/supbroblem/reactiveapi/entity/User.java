package com.supbroblem.reactiveapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "users")
public class User {

    @Id

    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String email;
    private String password;
}
