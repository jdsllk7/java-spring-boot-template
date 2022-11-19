package com.telusko.demo.registration.services;

import com.telusko.demo.security.model.User;
import com.telusko.demo.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public User findLoginUser(HttpServletRequest request) {

        try {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                return null;
            }

            return userRepository.findFirstByUsernameAndPassword(username, password);

        } catch (Exception e) {
            return null;
        }
    }
}
