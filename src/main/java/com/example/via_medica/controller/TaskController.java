package com.example.via_medica.controller;

import com.example.via_medica.Test;
import com.example.via_medica.models.Task;
import com.example.via_medica.persistance.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

//    private final TaskRepository taskRepository;
    private final Test test;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(){
        test.whatever();
        return ResponseEntity.status(200).body(Collections.emptyList());
    }



}
