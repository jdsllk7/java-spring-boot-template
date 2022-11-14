package com.telusko.demo.security.service;

import com.telusko.demo.commons.enums.Response;
import com.telusko.demo.security.model.User;
import com.telusko.demo.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public User findLoginUser(HttpServletRequest request) {

        try {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
                return null;
            }

            return userRepository.findFirstByEmailAndPassword(email, password);

        } catch (Exception e) {
            return null;
        }
    }

    public User userSession(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("user");
    }

    @Transactional(rollbackOn = Exception.class)
    public Map<String, Object> signup(MultipartHttpServletRequest map) {

        Map<String, Object> response = new HashMap<>();

        try {

            String email = map.getParameter("email");
            String password = map.getParameter("password");

            if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
                response.put(Response.STATUS, Response.ERROR);
                response.put(Response.MESSAGE, "Error. Kindly provide all field.");
                return response;
            }

            User user1 = userRepository.findFirstByEmailAndPassword(email, password);

            if (user1 != null) {
                response.put(Response.STATUS, Response.ERROR);
                response.put(Response.MESSAGE, "User account already exists. Please try again");
                return response;
            }

            User user2 = new User();
            user2.setEmail(email);
            user2.setPassword(password);
            userRepository.save(user2);

            response.put(Response.STATUS, Response.SUCCESS);
            response.put(Response.MESSAGE, "Account created successfully");

        } catch (Exception e) {
            response.put(Response.STATUS, Response.ERROR);
            response.put(Response.MESSAGE, "An error occurred. Please try again");
            return response;
        }

        return response;
    }
}
