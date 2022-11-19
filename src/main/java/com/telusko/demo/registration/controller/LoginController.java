package com.telusko.demo.registration.controller;

import com.telusko.demo.commons.enums.Response;
import com.telusko.demo.registration.services.LoginService;
import com.telusko.demo.security.model.User;
import com.telusko.demo.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/registration")
public class LoginController {

    private final UserService userService;
    private final LoginService loginService;

    @Autowired
    public LoginController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        User user = userService.userSession(request);
        if (user != null) {
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping(value = {"/login"})
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, String s) {

        Map<String, Object> response = new HashMap<>();

        User user = loginService.findLoginUser(request);

        if (user == null) {
            response.put(Response.STATUS, Response.ERROR);
            response.put(Response.MESSAGE, "Wrong credentials. Please try again");
            return response;
        }

        request.getSession().setAttribute("user", user);
        response.put(Response.STATUS, Response.SUCCESS);

        return response;
    }

}
