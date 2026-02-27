package com.taskflow.taskflow.repository;

import com.taskflow.taskflow.model.Action;
import org.springframework.stereotype.Repository;

import java.util.Stack;

@Repository
public class UndoRepository {

    private final Stack<Action> stack = new Stack<>();

    public Action push(Action action) {
        stack.push(action);
        return action;
    }

    public Action pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.pop();
    }

    public Action peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }
}