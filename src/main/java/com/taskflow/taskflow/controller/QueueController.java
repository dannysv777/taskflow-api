package com.taskflow.taskflow.controller;

import com.taskflow.taskflow.model.Task;
import com.taskflow.taskflow.service.QueueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/queue")
public class QueueController {

    private final QueueService service;

    public QueueController(QueueService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Task> enqueue(@RequestBody Map<String, String> body) {

        if (!body.containsKey("taskId") || body.get("taskId").isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Task task = service.enqueueTask(body.get("taskId"));
        return ResponseEntity.status(201).body(task);
    }

    @GetMapping("/next")
    public ResponseEntity<Task> peek() {
        return ResponseEntity.ok(service.peekTask());
    }

    @DeleteMapping
    public ResponseEntity<Task> dequeue() {
        return ResponseEntity.ok(service.dequeueTask());
    }
}