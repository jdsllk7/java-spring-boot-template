package com.telusko.demo.security.services;

import com.telusko.demo.security.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    public User userSession(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("user");
    }
}
