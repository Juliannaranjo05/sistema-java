package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@lombok.AllArgsConstructor
public class role {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private int roleid;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 255, nullable = true)
    private String description;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private List<user> users;
}