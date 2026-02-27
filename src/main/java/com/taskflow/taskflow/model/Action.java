package com.taskflow.taskflow.model;

import java.time.LocalDateTime;

public class Action {

    private String description;
    private LocalDateTime timestamp;

    public Action(String description) {
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}