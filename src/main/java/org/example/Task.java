package org.example;

public class Task {
    private int id;
    private String description;
    private String dueDate; // np. "2025-04-12"
    private int priority; // 1 - niski, 2 - średni, 3 - wysoki
    private boolean completed;

    public Task(int id, String description, String dueDate, int priority) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public Task(int id, String description, String dueDate, int priority, boolean completed) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private String priorityToString() {
        return switch (priority) {
            case 1 -> "niski";
            case 2 -> "średni";
            case 3 -> "wysoki";
            default -> "nieznany";
        };
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return id +  ";" + description +  ";" + dueDate +  ";" + priorityToString() +  ";" + completed;
    }
}
