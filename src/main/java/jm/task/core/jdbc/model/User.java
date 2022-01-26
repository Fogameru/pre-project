package jm.task.core.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public record User(@Id Long id, @Column String name, @Column String lastName, @Column byte age) {
    public User(String name, String lastName, byte age) {
        this(null, name, lastName, age);
    }
}