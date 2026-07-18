package com.firstspringproject.store.dto;

import com.firstspringproject.store.validations.Lowercase;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name is Required")
    @Size(max = 25, message = "Name must be less than 25 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Lowercase(message = "Email must be lowercase")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 4, max = 25, message = "Password must be between 4-25 characters")
    private String password;
}
