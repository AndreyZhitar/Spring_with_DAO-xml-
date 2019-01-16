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

    @GetMapping("/")
    public String view() {
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String getUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }


}
