package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "recovery_requests")
@Data
@NoArgsConstructor
public class recoveryRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El usuario al que pertenece la solicitud
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    // Código de recuperación único
    @Column(name = "recovery_code", nullable = false, unique = true)
    private String recoveryCode;

    // Fecha y hora de creación
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Fecha y hora de expiración del código
    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    // Si ya fue utilizada o no
    @Column(name = "used", nullable = false)
    private boolean used = false;

}