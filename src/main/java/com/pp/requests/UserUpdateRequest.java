package com.pp.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserUpdateRequest {

    private String fullName;
    private String userName;
    private String email;
    private String mobileNumber;
    private String password;
    private String country;

}
