package com.sitis.prueba.backendSitis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "profiles")
public class Profile {
    @Id
    @Column
    private String name;

    @Column
    private int id;

    @Column
    private String description;
}
