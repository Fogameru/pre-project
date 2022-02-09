package com.naito.springboot311.controller;

import com.naito.springboot311.model.User;
import com.naito.springboot311.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping("/")
    public String showAllUser(Model model) {
        model.addAttribute("allUser", userService.findAll());
        return "user";
    }

    @RequestMapping("addUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("save", true);
        return "editUser";
    }

    @RequestMapping("saveUser")
    public String saveUser(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("editUser/{id}")
    public String editUser(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("save", false);
        return "editUser";
    }

    @PostMapping("editUser/updateUser")
    public String updateUser(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("deleteUser")
    public String edit(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

}
