package com.naito.springboot311.controller;

import com.naito.springboot311.model.Roles;
import com.naito.springboot311.model.User;
import com.naito.springboot311.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Objects;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping("/")
    public String home(Model model, Principal principal) {
        if (Objects.nonNull(principal)) {
            model.addAttribute("infoUser", userService.findByUsername(principal.getName()));
        }
        return "home";
    }

    @RequestMapping("/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("infoUser", userService.findByUsername(principal.getName()));
        return "user";
    }

    @RequestMapping("/admin")
    public String showAllUser(Model model, Principal principal) {
        model.addAttribute("allUser", userService.findAll());
        model.addAttribute("roles_list", Roles.values());
        model.addAttribute("infoUser", userService.findByUsername(principal.getName()));
        return "admin";
    }

    @RequestMapping("/admin/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @RequestMapping("/admin/edit")
    public String edit(User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @RequestMapping("/admin/delete/{}")
    public String delete(@RequestParam Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

}
