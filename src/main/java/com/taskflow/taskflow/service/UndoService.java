package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.Action;
import com.taskflow.taskflow.repository.UndoRepository;
import org.springframework.stereotype.Service;

@Service
public class UndoService {

    private final UndoRepository repository;

    public UndoService(UndoRepository repository) {
        this.repository = repository;
    }

    public Action pushAction(String description) {
        Action action = new Action(description);
        return repository.push(action);
    }

    public Action popAction() {
        Action action = repository.pop();
        if (action == null) {
            throw new RuntimeException("No actions to undo");
        }
        return action;
    }

    public Action peekAction() {
        Action action = repository.peek();
        if (action == null) {
            throw new RuntimeException("No actions available");
        }
        return action;
    }
}