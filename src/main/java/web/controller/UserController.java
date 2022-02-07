package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showAllUser(Model model) {
        model.addAttribute("allUser", userService.getAllUser());
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
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("editUser/{id}")
    public String editUser(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("save", false);
        return "editUser";
    }

    @PostMapping("editUser/updateUser")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping("deleteUser")
    public String edit(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
