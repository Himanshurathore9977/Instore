package com.in.instore.response;

import com.in.instore.entity.enums.Roles;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private int userID;
    private Roles role;
    private String fullName;
    private String userName;
    private String email;
    private String mobileNumber;
    private String identityNumber;
    private String country;
    private Boolean activeUser;
    private Long merchantID;
}
