package com.example.via_medica.controller;

import com.example.via_medica.controller.models.UpdateFieldRequest;
import com.example.via_medica.controller.models.WebException;
import com.example.via_medica.persistance.models.FieldView;
import com.example.via_medica.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fields")
@RequiredArgsConstructor
public class FieldController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<FieldView>> fetchAllFields() {
        return ResponseEntity.ok(taskService.fetchAllFields());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateField(@PathVariable Long id, @RequestBody UpdateFieldRequest requestBody) {
        try {
            return ResponseEntity.ok(taskService.updateField(id, requestBody.getTechnicianId()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(WebException.builder().message(e.getMessage()).build());
        }
    }
}
