package com.sitis.prueba.backendSitis.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String passwordConfirm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Profile profile;
}
