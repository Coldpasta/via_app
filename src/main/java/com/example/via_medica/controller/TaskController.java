package com.example.via_medica.controller;

import com.example.via_medica.Test;
import com.example.via_medica.controller.models.UpdateTaskRequest;
import com.example.via_medica.controller.models.WebException;
import com.example.via_medica.persistance.models.Task;
import com.example.via_medica.persistance.TaskRepository;
import com.example.via_medica.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;
    private final Test test;
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        test.whatever();
        return ResponseEntity.status(200).body(taskRepository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody UpdateTaskRequest requestBody) {
        try {
            return ResponseEntity.ok(taskService.updateTask(id, requestBody.getFieldId()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(WebException.builder().message(e.getMessage()).build());
        }
    }

}
