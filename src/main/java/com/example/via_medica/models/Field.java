package com.example.via_medica.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Obszar")
@Data
public class Field {
    @Id
    @Column(name = "Identyfikator")
    private int id;
    @Column(name = "Nazwa")
    private String name;
    @Column(name = "Aktywny")
    private int active;
    @Column(name = "IdentyfikatorSerwisanta")
    private int techicianId;


}
