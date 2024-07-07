package com.example.via_medica.persistance;

import com.example.via_medica.persistance.models.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {

    List<Field> findAllByTechnicianId(Long technicianId);

}
