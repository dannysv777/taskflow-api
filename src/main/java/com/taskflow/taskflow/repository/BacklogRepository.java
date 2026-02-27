package com.taskflow.taskflow.repository;

import com.taskflow.taskflow.model.Task;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.Optional;

@Repository
public class BacklogRepository {

    private final LinkedList<Task> tasks = new LinkedList<>();

    public Task save(Task task) {
        tasks.addLast(task);
        return task;
    }

    public LinkedList<Task> findAll() {
        return tasks;
    }

    public Optional<Task> findById(String id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public boolean deleteById(String id) {
        return tasks.removeIf(t -> t.getId().equals(id));
    }
}