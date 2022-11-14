package com.telusko.demo.security.repository;

import com.telusko.demo.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findFirstByEmailAndPassword(String email, String password);
}
