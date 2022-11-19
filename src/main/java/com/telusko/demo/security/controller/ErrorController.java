package com.telusko.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/security")
public class ErrorController {

    @GetMapping("/404")
    public String error404(HttpServletRequest request) {
        return "404";
    }

}
