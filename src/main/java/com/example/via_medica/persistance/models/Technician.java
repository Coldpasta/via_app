package com.example.via_medica.persistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Serwisant")
@Data
public class Technician {

    @Id
    @Column(name = "Identyfikator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nazwisko")
    private String surname;
    @Column(name = "Aktywny")
    private Integer active;
    @Column(name = "Email")
    private String email;

}
