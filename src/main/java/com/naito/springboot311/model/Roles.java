package com.naito.springboot311.model;

public enum Roles {
    ADMIN(new Role("Admin")),
    USER(new Role("User"));

    Roles(Role role) {
    }
}
