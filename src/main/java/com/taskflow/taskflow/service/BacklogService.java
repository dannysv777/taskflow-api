package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.Task;
import com.taskflow.taskflow.repository.BacklogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogService {

    private final BacklogRepository repository;

    public BacklogService(BacklogRepository repository) {
        this.repository = repository;
    }

    public Task createTask(String title) {
        Task task = new Task(title);
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(String id) {
        boolean removed = repository.deleteById(id);
        if (!removed) {
            throw new RuntimeException("Task not found");
        }
    }
}