package com.naito.springboot311.model;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private int age;
    private String username;
    private String password;
    private Set<Role> roles;
}
