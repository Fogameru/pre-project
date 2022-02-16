package com.naito.springboot311.controller;

import com.naito.springboot311.mapper.UserMapper;
import com.naito.springboot311.model.Role;
import com.naito.springboot311.model.Roles;
import com.naito.springboot311.model.UserDto;
import com.naito.springboot311.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public @ResponseBody
    List<UserDto> getAll() {
        return userMapper.toDtos(userService.findAll());
    }

    @GetMapping("me")
    public @ResponseBody
    UserDto getCurrentUser(Principal principal) {
        return userMapper.toDto(userService.findByUsername(principal.getName()));
    }

    @GetMapping("/{id}")
    public @ResponseBody
    UserDto get(@PathVariable Long id) {
        return userMapper.toDto(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto user) {
        return ResponseEntity.ok(userMapper.toDto(userService.save(userMapper.toUser(user))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/roles")
    public @ResponseBody
    List<Role> roles() {
        return Arrays.stream(Roles.values())
                .map(Roles::getRole)
                .toList();
    }
}
