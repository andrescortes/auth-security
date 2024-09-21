package com.app.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterUser implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String role;
    private String jwt;
}
