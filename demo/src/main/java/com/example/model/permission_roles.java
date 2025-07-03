package com.example.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@lombok.AllArgsConstructor

@Entity(name="permission_role")
public class permission_roles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_roleid")
    private int permission_roleid;
    @ManyToOne
    @JoinColumn(name = "pageid", nullable = false)
    private pages page;
    @ManyToOne
    @JoinColumn(name = "roleid", nullable = false)
    private role role;
    @Column(name = "type", nullable = false)
    private String type;
    
}
