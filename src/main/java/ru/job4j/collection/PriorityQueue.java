package ru.job4j.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PriorityQueue {
    private final LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var index = 0;
        for (var element : tasks) {
            if (element.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }

    // Новый метод поиска с предикатами
    public List<Task> find(String key) {
        Predicate<Task> byName = t -> t.getName().contains(key);
        Predicate<Task> byDescription = t -> t.getDescription().contains(key);
        Predicate<Task> byType = t -> t.getType().contains(key);
        Predicate<Task> byPriority = t -> String.valueOf(t.getPriority()).contains(key);

        Predicate<Task> combined = byName
                .or(byDescription)
                .or(byType)
                .or(byPriority);

        return tasks.stream()
                .filter(combined)
                .collect(Collectors.toList());
    }
}

