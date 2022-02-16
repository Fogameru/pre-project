package com.naito.springboot311.model;

public enum Roles {
    ADMIN(new Role("ADMIN")),
    USER(new Role("USER"));

    private Role role;

    Roles(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
