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
        if (Objects.isNull(userService.findByUsername("Dereck"))
                && Objects.isNull(userService.findByUsername("Anna"))
                && Objects.isNull(userService.findByUsername("Kratos"))) {
            userService.save(User.builder()
                    .firstname("Dereck")
                    .lastname("Storm")
                    .age(35)
                    .username("Dereck")
                    .password("Dereck")
                    .roles(Set.of(new Role("USER")))
                    .build());
            userService.save(User.builder()
                    .firstname("Anna")
                    .lastname("Portman")
                    .age(20)
                    .username("Anna")
                    .password("Anna")
                    .roles(Set.of(new Role("ADMIN")))
                    .build());
            userService.save(User.builder()
                    .firstname("Kratos")
                    .lastname("God Of War")
                    .age(487987)
                    .username("Kratos")
                    .password("Kratos")
                    .roles(Set.of(new Role("ADMIN"), new Role("USER")))
                    .build());
        }

    }
}
