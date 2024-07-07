package com.example.via_medica.models;

import jakarta.persistence.*;
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

}
