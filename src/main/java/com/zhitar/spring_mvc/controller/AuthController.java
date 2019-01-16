package com.zhitar.spring_mvc.controller;

import com.zhitar.spring_mvc.model.User;
import com.zhitar.spring_mvc.service.UserService;
import com.zhitar.spring_mvc.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/users/new")
    public String getSignUp(Model model) {
        model.addAttribute("user", new User());
        return "auth/sign_up";
    }

    @PostMapping("/users/new")
    public String signUn(@ModelAttribute @Valid User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "auth/sign_up";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "auth/sign_in";
    }
}
