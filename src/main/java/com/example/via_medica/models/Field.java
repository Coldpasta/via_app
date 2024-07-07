package com.example.via_medica.models;

import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdentyfikatorSerwisanta", nullable = false) private Technician technician;


}
