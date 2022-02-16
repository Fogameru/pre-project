package com.naito.springboot311.controller;

import com.naito.springboot311.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/admin")
    public String showAllUser() {
        return "admin";
    }
//
//    @RequestMapping("/admin/add")
//    public String add(User user, Model model) {
//        userService.save(user);
//        return "redirect:/admin";
//    }
//
//    @RequestMapping("/admin/edit")
//    public String edit(User user) {
//        userService.save(user);
//        return "redirect:/admin";
//    }
//
//    @RequestMapping("/admin/delete/{}")
//    public String delete(@RequestParam Long id) {
//        userService.deleteById(id);
//        return "redirect:/admin";
//    }

}
