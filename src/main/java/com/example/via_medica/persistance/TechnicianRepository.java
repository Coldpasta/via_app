package com.example.via_medica.persistance;

import com.example.via_medica.models.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {

}
