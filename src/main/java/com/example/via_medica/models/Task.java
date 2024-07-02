package com.example.via_medica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Działanie")
@Data
public class Task {
    @Id
    @Column(name = "Identyfikator")
    private int id;
    @Column(name = "IdentyfikatorSerwisanta")
    private int technicianId;
    @Column(name = "IdentyfikatorObszaru")
    private int taskId;
    @Column(name = "OpisDziałania")
    private String taskDescription;
    @Column(name = "PlanowanyCzas")
    private int executionTime;

}
