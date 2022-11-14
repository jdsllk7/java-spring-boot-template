package com.telusko.demo.security.controller;

import com.telusko.demo.commons.enums.Response;
import com.telusko.demo.security.model.User;
import com.telusko.demo.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public String login(HttpServletRequest request) {
        User user = userService.userSession(request);
        if (user != null) {
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping(value = {"login"})
    @ResponseBody
    public Map<String, Object> loginPost(HttpServletRequest request) {

        Map<String, Object> response = new HashMap<>();

        User user = userService.findLoginUser(request);

        if (user == null) {
            response.put(Response.STATUS, Response.ERROR);
            response.put(Response.MESSAGE, "Wrong credentials. Please try again");
            return response;
        }

        request.getSession().setAttribute("user", user);
        response.put(Response.STATUS, Response.SUCCESS);

        return response;
    }

    @GetMapping(value = {"logout"})
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }

}
