package com.pp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pp.enums.Roles;
import lombok.*;

import javax.persistence.*;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User  extends CreatedDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles role;

    @Column(name = "fullName" , nullable = false)
    private String fullName;

    @Column(name = "userName", unique = true, nullable = false)
    private String userName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "mobileNumber", unique = true, nullable = false)
    private String mobileNumber;

    @Column(name = "countryISO", nullable = false, length = 3)
    private String countryISO;

    @Column(name = "activeUser")
    private boolean activeUser = true ;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Column(name = "resetPassword")
    private String resetPassword;

    @Column(name = "identityNumber" , unique = true, nullable = false, length = 10)
    private Long identityNumber ;

    @Column(name = "merchantID")
    private Long merchantID;

}
