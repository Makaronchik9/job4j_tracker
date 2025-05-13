package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    @Test
    public void whenAddTasksThenTakeInPriorityOrder() {
        PriorityQueue queue = new PriorityQueue();

        Task task1 = new Task("Fix bug", "Fix critical bug", "Bug", 1);
        Task task2 = new Task("Add feature", "Add new feature", "Feature", 2);
        Task task3 = new Task("Update docs", "Update project documentation", "Documentation", 3);

        queue.put(task2);
        queue.put(task1);
        queue.put(task3);

        assertEquals(task1, queue.take());
        assertEquals(task2, queue.take());
        assertEquals(task3, queue.take());
    }
}
