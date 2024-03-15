package com.pp.response;

import com.pp.enums.Roles;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Long userID;
    private Roles role;
    private String fullName;
    private String userName;
    private String email;
    private String mobileNumber;
    private String identityNumber;
    private String countryISO;
    private boolean activeUser;
    private Long merchantID;
}
