package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    private String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "listUser";
    }

    @GetMapping ("/new")
    private String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/save")
    private String save(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    private String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
        return "edit";
    }

    @GetMapping("/delete")
    private String delete(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
