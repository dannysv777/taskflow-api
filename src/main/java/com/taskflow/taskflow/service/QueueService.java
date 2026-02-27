package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.Task;
import com.taskflow.taskflow.repository.BacklogRepository;
import com.taskflow.taskflow.repository.QueueRepository;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    private final QueueRepository queueRepository;
    private final BacklogRepository backlogRepository;

    public QueueService(QueueRepository queueRepository,
                        BacklogRepository backlogRepository) {
        this.queueRepository = queueRepository;
        this.backlogRepository = backlogRepository;
    }

    public Task enqueueTask(String taskId) {

        Task task = backlogRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        return queueRepository.enqueue(task);
    }

    public Task dequeueTask() {
        Task task = queueRepository.dequeue();
        if (task == null) {
            throw new RuntimeException("Queue is empty");
        }
        return task;
    }

    public Task peekTask() {
        Task task = queueRepository.peek();
        if (task == null) {
            throw new RuntimeException("Queue is empty");
        }
        return task;
    }
}