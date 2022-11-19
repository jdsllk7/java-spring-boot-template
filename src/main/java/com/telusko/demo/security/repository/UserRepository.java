package com.telusko.demo.security.repository;

import com.telusko.demo.security.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findFirstByUsernameAndPassword(String username, String password);

    User findFirstByUsername(String username);

}
