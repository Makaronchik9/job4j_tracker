package ru.job4j.collection;

public class Task {
    private final String name;
    private final String description;
    private final String type;
    private final int priority;

    public Task(String name, String description, String type, int priority) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return name + " | " + description + " | " + type + " | " + priority;
    }
}

