package com.telusko.demo.home.controller;

import com.telusko.demo.security.model.User;
import com.telusko.demo.registration.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private final LoginService userService;

    @Autowired
    public HomeController(LoginService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {

        User user = userService.userSession(request);
        model.addAttribute("user", user);
        return "home";
    }
}
