package com.naito.springboot311.controller;

import com.naito.springboot311.model.Roles;
import com.naito.springboot311.model.User;
import com.naito.springboot311.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("infoUser", userService.findByLogin(principal.getName()));
        return "user";
    }

    @RequestMapping("/admin")
    public String showAllUser(Model model) {
        model.addAttribute("allUser", userService.findAll());
        return "admin";
    }

    @RequestMapping("/adduser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles_list", Roles.values());
        model.addAttribute("save", true);
        return "editUser";
    }

    @RequestMapping("/saver")
    public String saveUser(User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @RequestMapping("/edits/{id}")
    public String editUser(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("roles_list", Roles.values());
        model.addAttribute("save", false);
        return "editUser";
    }

    @PostMapping("/edits/updates")
    public String updateUser(User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @RequestMapping("/deletes")
    public String edit(@RequestParam Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

}
