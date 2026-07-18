package com.firstspringproject.store.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginReqestDto {

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Password is required.")
    private String password;

}
