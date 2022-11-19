package com.telusko.demo.registration.services;

import com.telusko.demo.appuser.AppUser;
import com.telusko.demo.appuser.AppUserService;
import com.telusko.demo.commons.enums.Response;
import com.telusko.demo.security.enums.UserRole;
import com.telusko.demo.security.model.User;
import com.telusko.demo.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class SignupService {

    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    @Transactional(rollbackOn = Exception.class)
    public Map<String, Object> signup(MultipartHttpServletRequest map) {

        Map<String, Object> response = new HashMap<>();

        try {

            String username = map.getParameter("username");
            String password = map.getParameter("password");
            String firstName = map.getParameter("firstName");
            String lastName = map.getParameter("lastName");

            if (username == null || username.isEmpty() || password == null || password.isEmpty() ||
                    firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
                response.put(Response.STATUS, Response.ERROR);
                response.put(Response.MESSAGE, "Error. Kindly provide all field.");
                return response;
            }




            String token = appUserService.signUpUser(
                    new AppUser(
                            firstName,
                            lastName,
                            username,
                            password,
                            UserRole.USER

                    )
            );

            String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
            /*emailSender.send(
                    request.getEmail(),
                    buildEmail(request.getFirstName(), link));

            return token;*/

















            User user1 = userRepository.findFirstByUsernameAndPassword(username, password);

            if (user1 != null) {
                response.put(Response.STATUS, Response.ERROR);
                response.put(Response.MESSAGE, "User account already exists. Please try again");
                return response;
            }

            User user2 = new User();
            user2.setUsername(username);
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
