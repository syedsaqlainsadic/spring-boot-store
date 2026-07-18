package com.firstspringproject.store.dto;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String oldpassword;
    private String newpassword;

}
