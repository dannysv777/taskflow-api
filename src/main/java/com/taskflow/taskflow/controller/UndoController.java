package com.taskflow.taskflow.controller;

import com.taskflow.taskflow.model.Action;
import com.taskflow.taskflow.service.UndoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/undo")
public class UndoController {

    private final UndoService service;

    public UndoController(UndoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Action> push(@RequestBody Map<String, String> body) {

        if (!body.containsKey("description") || body.get("description").isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Action action = service.pushAction(body.get("description"));
        return ResponseEntity.status(201).body(action);
    }

    @GetMapping("/peek")
    public ResponseEntity<Action> peek() {
        return ResponseEntity.ok(service.peekAction());
    }

    @DeleteMapping
    public ResponseEntity<Action> pop() {
        return ResponseEntity.ok(service.popAction());
    }
}   