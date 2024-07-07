package com.example.via_medica.services;

import com.example.via_medica.persistance.FieldRepository;
import com.example.via_medica.persistance.TaskRepository;
import com.example.via_medica.persistance.TechnicianRepository;
import com.example.via_medica.persistance.models.Field;
import com.example.via_medica.persistance.models.Task;
import com.example.via_medica.persistance.models.Technician;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final TaskRepository taskRepository;
    private final FieldRepository fieldRepository;
    private final TechnicianRepository technicianRepository;
    private final EmailService emailService;
    private static final String SUBJECT = "tasks assigned";
    private static final String MESSAGE = "technician with id %d has the following tasks assigned: %s";

    public void reportTasksForTechnicians() {
        List<Technician> technicians = technicianRepository.findAll();
        for (Technician technician : technicians) {
            List<Task> tasks = taskRepository.findAllByTechnicianId(technician.getId());

            String taskIds = Optional.ofNullable(tasks)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(Task::getId)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            emailService.sendMessage(technician.getEmail(), SUBJECT, MESSAGE.formatted(technician.getId(), taskIds));
        }
    }

    public List<Task> getTasksForTechnician(Long technicianId) {
        return taskRepository.findAllByTechnicianId(technicianId);
    }

    public List<Field> getFieldsForTechnician(Long technicianId) {
        return fieldRepository.findAllByTechnicianId(technicianId);
    }

}
