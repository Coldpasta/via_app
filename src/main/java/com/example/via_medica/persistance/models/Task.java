package com.example.via_medica.persistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Działanie")
@Data
public class Task {

    @Id
    @Column(name = "Identyfikator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "IdentyfikatorObszaru")
    private Long fieldId;
    @Column(name = "IdentyfikatorSerwisanta")
    private Long technicianId;
    @Column(name = "OpisDziałania")
    private String taskDescription;
    @Column(name = "PlanowanyCzas")
    private Long executionTime;

}
