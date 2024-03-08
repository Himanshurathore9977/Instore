package com.in.instore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in.instore.entity.enums.Roles;
import lombok.*;

import javax.persistence.*;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Roles role;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "userName", unique = true)
    private String userName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "mobileNumber", unique = true)
    private String mobileNumber;

    @Column(name = "identityNumber", unique = true)
    private String identityNumber;

    @Column(name = "country")
    private String country;

    @Column(name = "activeUser")
    private boolean activeUser;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Column(name = "resetPassword")
    private String resetPassword;

    @Column(name = "merchantID")
    private Long merchantID;
}
