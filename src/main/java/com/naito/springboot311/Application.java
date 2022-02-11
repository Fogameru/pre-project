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
        if (Objects.isNull(userService.findByLogin("TestUser"))
                && Objects.isNull(userService.findByLogin("TestAdmin"))
                && Objects.isNull(userService.findByLogin("TestAdminAdnUser"))) {
            userService.save(User.builder()
                    .name("TestUser")
                    .lastName("TestLastName")
                    .age(957)
                    .login("TestUser")
                    .password("123")
                    .roles(Set.of(new Role("USER")))
                    .build());
            userService.save(User.builder()
                    .name("TestAdmin")
                    .lastName("TestLastNameAdmin")
                    .age(957)
                    .login("TestAdmin")
                    .password("123")
                    .roles(Set.of(new Role("ADMIN")))
                    .build());
            userService.save(User.builder()
                    .name("TestAdminAdnUser")
                    .lastName("TestLastNameAdminAndser")
                    .age(957)
                    .login("TestAdminAdnUser")
                    .password("123")
                    .roles(Set.of(new Role("ADMIN"), new Role("USER")))
                    .build());
        }

    }
}
