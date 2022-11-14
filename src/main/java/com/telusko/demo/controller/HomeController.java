package com.telusko.demo.controller;

import com.telusko.demo.model.User;
import com.telusko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("home")
    public String home(Model model, HttpServletRequest request) {

        User user = userService.userSession(request);
        model.addAttribute("user", user);
        return "home";
    }

    @GetMapping("about-us")
    public String aboutUs(Model model, HttpServletRequest request) {

        User user = userService.userSession(request);
        model.addAttribute("user", user);
        return "about-us";
    }

}
