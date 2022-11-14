package com.telusko.demo.security.controller;

import com.telusko.demo.security.model.User;
import com.telusko.demo.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class SignupController {

    private final UserService userService;

    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("signup")
    public String signup(HttpServletRequest request) {

        User user = userService.userSession(request);
        if (user != null) {
            return "redirect:/home";
        }

        return "signup";
    }

    @PostMapping(value = {"signup"})
    @ResponseBody
    public Map<String, Object> signup(MultipartHttpServletRequest map) {
        return userService.signup(map);
    }

}
