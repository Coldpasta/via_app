package com.example.via_medica;

import com.example.via_medica.persistance.FieldViewRepository;
import com.example.via_medica.persistance.models.Field;
import com.example.via_medica.persistance.models.FieldView;
import com.example.via_medica.persistance.models.Task;
import com.example.via_medica.persistance.models.Technician;
import com.example.via_medica.persistance.FieldRepository;
import com.example.via_medica.persistance.TaskRepository;
import com.example.via_medica.persistance.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Test {

    private final TaskRepository taskRepository;
    private final TechnicianRepository technicianRepository;
    private final FieldRepository fieldRepository;
    private final FieldViewRepository fieldViewRepository;

    public void whatever() {
        Technician technician = new Technician();
        technician.setActive(1);
        technician.setSurname("Stefan");
        technicianRepository.save(technician);

        Technician technician2 = new Technician();
        technician2.setActive(1);
        technician2.setSurname("doqnowdq");
        technicianRepository.save(technician2);

        FieldView fieldView = new FieldView();
        fieldView.setName("Midfield");
        fieldView.setActive(1);
        fieldView.setTechnicianId(1L);
        fieldView.setTechnicianActive(1);
        fieldView.setTechnicianSurname("Stefan");
        fieldViewRepository.save(fieldView);

        Field field = new Field();
        field.setActive(1);
        field.setName("Midfield");
        field.setTechnicianId(1L);
        fieldRepository.save(field);

        Task task = new Task();
        task.setTaskDescription("pranie");
        task.setExecutionTime(200L);
        task.setFieldId(1L);
        task.setTechnicianId(1L);
        taskRepository.save(task);
    }


}
