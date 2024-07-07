package com.example.via_medica;

import com.example.via_medica.models.Task;
import com.example.via_medica.models.Field;
import com.example.via_medica.models.Technician;
import com.example.via_medica.persistance.FieldRepository;
import com.example.via_medica.persistance.TaskRepository;
import com.example.via_medica.persistance.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Test {
//    private final TaskRepository taskRepository;
    private final TechnicianRepository technicianRepository;
    private final FieldRepository fieldRepository;

    public void whatever (){
        Technician technician = new Technician();
        technician.setId(100L);
        technician.setActive(1);
        technician.setSurname("Stefan");
        technicianRepository.save(technician);
        Field field = new Field();
        field.setId(1000L);
        field.setName("Midfield");
        field.setActive(1);
       field.setTechnician(technician);
        fieldRepository.save(field);
//        Task task = new Task();
//        task.setId(10000L);
//        task.setTaskDescription("pranie");
//        task.setTechnician(technician);
//        task.setField(field);
//        task.setExecutionTime(200L);


    }


}
