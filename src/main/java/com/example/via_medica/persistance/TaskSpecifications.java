package com.example.via_medica.persistance;

import com.example.via_medica.models.Field;
import com.example.via_medica.models.Task;
import com.example.via_medica.models.Technician;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecifications {

    public static Specification<Task> hasTechnicianWithId (int technicianId){
        return (root, query, criteriaBuilder) -> {
            Join<Technician,Task> taskTechnician = root.join("Serwisant");
            return criteriaBuilder.equal(taskTechnician.get("Identyfikator"),technicianId);
        };
    }
    public static Specification<Task> hasTFieldWithId (int fieldId){
        return (root, query, criteriaBuilder) -> {
            Join<Field,Task> taskTechnician = root.join("Obszar");
            return criteriaBuilder.equal(taskTechnician.get("Identyfikator"),fieldId);
        };
    }


}
