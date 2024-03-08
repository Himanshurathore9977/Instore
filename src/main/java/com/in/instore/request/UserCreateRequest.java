package com.in.instore.request;

import com.in.instore.entity.enums.Roles;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserCreateRequest {

    private Roles role;
    private String fullName;
    private String userName;
    private String email;
    private String mobileNumber;
    private String country;
    private String password;
    private Long merchantID;
}
