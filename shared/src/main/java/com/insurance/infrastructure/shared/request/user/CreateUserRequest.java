package com.insurance.infrastructure.shared.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    @NotBlank(message = "Username must not be blank")
    @Size(min = 4, max = 12, message = "Username length must be between 4 and 12 characters")
    private String username;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 8, max = 16, message = "Password length must be between 8 and 16 characters")
    private String password;

    private Integer department;
    private Integer workSite;

    private String updatedBy;
}
