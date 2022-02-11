package com.naito.springboot311;

import com.naito.springboot311.model.Role;
import com.naito.springboot311.model.User;
import com.naito.springboot311.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {
    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        if (Objects.isNull(userService.findByUsername("TestUser"))
                && Objects.isNull(userService.findByUsername("TestAdmin"))
                && Objects.isNull(userService.findByUsername("TestAdminAdnUser"))) {
            userService.save(User.builder()
                    .firstname("TestUser")
                    .lastname("TestLastName")
                    .age(957)
                    .username("TestUser")
                    .password("123")
                    .roles(Set.of(new Role("USER")))
                    .build());
            userService.save(User.builder()
                    .firstname("TestAdmin")
                    .lastname("TestLastNameAdmin")
                    .age(957)
                    .username("TestAdmin")
                    .password("123")
                    .roles(Set.of(new Role("ADMIN")))
                    .build());
            userService.save(User.builder()
                    .firstname("TestAdminAdnUser")
                    .lastname("TestLastNameAdminAndUser")
                    .age(957)
                    .username("TestAdminAdnUser")
                    .password("123")
                    .roles(Set.of(new Role("ADMIN"), new Role("USER")))
                    .build());
        }

    }
}
