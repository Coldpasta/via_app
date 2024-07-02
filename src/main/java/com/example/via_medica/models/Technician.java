package com.example.via_medica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Serwisant")
@Data
public class Technician {
    @Id
    @Column(name = "Identyfikator")
    private int id;
    @Column(name = "Nazwisko")
    private String surname;
    @Column(name = "Aktywny")
    private int active;

}
