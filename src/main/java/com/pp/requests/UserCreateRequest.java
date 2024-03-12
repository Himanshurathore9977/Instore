package com.pp.requests;

import com.pp.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserCreateRequest {

    private Roles role;
    @NotBlank(message = "please provide full name properly")
    private String fullName;

    @NotEmpty(message = "Username cannot be NULL")
    private String userName;

    @Email(message = "Please enter a valid email Id")
    @NotNull(message = "Email cannot be NULL")
    private String email;

    @NotEmpty(message = "Please provide proper emailId "  )
    @Size(min = 10 , max = 10 , message = "Please Enter 10 digit Mobile Number")
    private String mobileNumber;
    private String country;
    private String password;
    private Long merchantID;
}
