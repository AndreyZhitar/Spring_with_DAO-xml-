package com.zhitar.spring_mvc.controller;

import com.zhitar.spring_mvc.model.User;
import com.zhitar.spring_mvc.service.UserService;
import com.zhitar.spring_mvc.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/")
    public String view(@RequestParam(name = "name", defaultValue = "hello") String msg, Model model) {
        model.addAttribute("msg", msg);
        return "index";
    }

    @GetMapping("/users")
    public String getUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/users/new")
    public String getSignUp(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @PostMapping("/users/new")
    public String signUn(@ModelAttribute @Valid User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "sign_up";
        }
        userService.save(user);
        return "redirect:/users";
    }
}
