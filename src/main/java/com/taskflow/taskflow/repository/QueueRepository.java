package com.taskflow.taskflow.repository;

import com.taskflow.taskflow.model.Task;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.Queue;

@Repository
public class QueueRepository {

    private final Queue<Task> queue = new LinkedList<>();

    public Task enqueue(Task task) {
        queue.add(task);
        return task;
    }

    public Task dequeue() {
        return queue.poll(); // devuelve null si está vacía
    }

    public Task peek() {
        return queue.peek();
    }
}