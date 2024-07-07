package com.example.via_medica.services;

import com.example.via_medica.persistance.FieldRepository;
import com.example.via_medica.persistance.FieldViewRepository;
import com.example.via_medica.persistance.TaskRepository;
import com.example.via_medica.persistance.TechnicianRepository;
import com.example.via_medica.persistance.models.Field;
import com.example.via_medica.persistance.models.FieldView;
import com.example.via_medica.persistance.models.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private static final String TECHNICIAN = "technician";
    private static final String FIELD = "field";
    private static final String TASK = "task";
    private static final String NOT_PRESENT_ERROR_MESSAGE = "%s with id %d is not present in database";

    private final FieldRepository fieldRepository;
    private final FieldViewRepository fieldViewRepository;
    private final TechnicianRepository technicianRepository;
    private final TaskRepository taskRepository;

    public List<FieldView> fetchAllFields() {
        return fieldViewRepository.findAll();
    }

    public Field updateField(Long fieldId, Long technicianId) {
        Optional<Field> fieldOptional = fieldRepository.findById(fieldId);
        if (fieldOptional.isEmpty()) {
            throw new IllegalArgumentException(NOT_PRESENT_ERROR_MESSAGE.formatted(FIELD, fieldId));
        }
        if (!technicianRepository.existsById(technicianId)) {
            throw new IllegalArgumentException(NOT_PRESENT_ERROR_MESSAGE.formatted(TECHNICIAN, technicianId));
        }

        Field field = fieldOptional.get();
        field.setTechnicianId(technicianId);
        fieldRepository.save(field);

        return field;
    }

    public Task updateTask(Long taskId, Long fieldId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isEmpty()) {
            throw new IllegalArgumentException(NOT_PRESENT_ERROR_MESSAGE.formatted(TASK, taskId));
        }
        if (!fieldRepository.existsById(fieldId)) {
            throw new IllegalArgumentException(NOT_PRESENT_ERROR_MESSAGE.formatted(FIELD, fieldId));
        }

        Task task = taskOptional.get();
        task.setFieldId(fieldId);
        taskRepository.save(task);

        return task;
    }

}
