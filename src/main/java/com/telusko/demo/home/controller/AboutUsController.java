package com.telusko.demo.home.controller;

import com.telusko.demo.security.model.User;
import com.telusko.demo.registration.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class AboutUsController {

    private final LoginService userService;

    @Autowired
    public AboutUsController(LoginService userService) {
        this.userService = userService;
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model, HttpServletRequest request) {

        User user = userService.userSession(request);
        model.addAttribute("user", user);
        return "about-us";
    }

}
