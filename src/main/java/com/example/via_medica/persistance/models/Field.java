package com.example.via_medica.persistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Obszar")
@Data
public class Field {

    @Id
    @Column(name = "Identyfikator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nazwa")
    private String name;
    @Column(name = "Aktywny")
    private Integer active;
    @Column(name = "IdentyfikatorSerwisanta")
    private Long technicianId;

}
