package com.telusko.demo.security.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "sec_confirmation_token", schema = "java_spring_test_db")
public class ConfirmationToken implements Serializable {

    public ConfirmationToken(String token, LocalDateTime createdDate, LocalDateTime expiryDate, User user) {
        this.token = token;
        this.createdDate = createdDate;
        this.expiryDate = expiryDate;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "token", nullable = false)
    private String token;

    @Basic
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Basic
    @Column(name = "expiry_date", nullable = false)
    private LocalDateTime expiryDate;

    @Basic
    @Column(name = "confirmation_date", nullable = false)
    private LocalDateTime confirmationDate;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private User user;

}