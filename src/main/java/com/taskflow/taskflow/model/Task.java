package com.taskflow.taskflow.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {

    private String id;
    private String title;
    private LocalDateTime createdAt;

    public Task(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;S
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}