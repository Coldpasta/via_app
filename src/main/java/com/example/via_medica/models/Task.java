package com.example.via_medica.models;

import jakarta.persistence.*;
import lombok.Data;



@Data
public class Task {
    @Id
    @Column(name = "Identyfikator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "IdentyfikatorObszaru", nullable = false) private Field field;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "IdentyfikatorSerwisanta", nullable = false) private Technician technician;
//    @Column(name = "OpisDziałania")
//    private String taskDescription;
//    @Column(name = "PlanowanyCzas")
//    private Long executionTime;

}
