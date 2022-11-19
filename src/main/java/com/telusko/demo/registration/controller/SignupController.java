package com.telusko.demo.registration.controller;

import com.telusko.demo.registration.services.LoginService;
import com.telusko.demo.registration.services.SignupService;
import com.telusko.demo.security.model.User;
import com.telusko.demo.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/registration")
public class SignupController {

    private final SignupService signupService;
    private final UserService userService;


    @Autowired
    public SignupController(SignupService signupService, UserService userService) {
        this.signupService = signupService;
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signup(HttpServletRequest request) {

        User user = userService.userSession(request);
        if (user != null) {
            return "redirect:/home";
        }

        return "signup";
    }

    @PostMapping(value = {"/signup"})
    @ResponseBody
    public Map<String, Object> signup(MultipartHttpServletRequest map) {
        return signupService.signup(map);
    }

}
