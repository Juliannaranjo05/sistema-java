package com.example.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recovery_RequestDTO {
    @JsonProperty("id")
    private int recovery_requestid;
    private String email;
    private String password;
    private String expirationTime;
    private String user;
}
