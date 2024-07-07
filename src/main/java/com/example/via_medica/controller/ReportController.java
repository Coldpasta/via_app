package com.example.via_medica.controller;

import com.example.via_medica.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/tasks")
    public void reportTasks() {
        reportService.reportTasksForTechnicians();
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getTasksForTechnician(@RequestParam("technician_id") Long technicianId) {
        return ResponseEntity.ok(reportService.getTasksForTechnician(technicianId));
    }

    @GetMapping("/fields")
    public ResponseEntity<?> getFieldsForTechnician(@RequestParam("technician_id") Long technicianId) {
        return ResponseEntity.ok(reportService.getFieldsForTechnician(technicianId));
    }
}
