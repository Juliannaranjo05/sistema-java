package com.example.DTO;

import com.example.model.pages;
import com.example.model.role;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
public class Permission_RoleDTO {
    @JsonProperty("id")
    private int permission_roleid;
    private pages page;
    private role role;
    private String type;
}
