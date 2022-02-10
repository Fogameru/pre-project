package com.naito.springboot311.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Embeddable;


@Embeddable
@Getter
@Setter
public class Role implements GrantedAuthority {
    private String role;

    public Role() {
    }

    public Role(String name) {
        this.role = name;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}
