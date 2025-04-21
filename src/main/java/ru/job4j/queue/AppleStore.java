package ru.job4j.queue;

import java.util.Queue;
import java.util.LinkedList;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String result = null;
        Queue<Customer> copyQueue = new LinkedList<>(queue);
        for (int i = 0; i < count && !copyQueue.isEmpty(); i++) {
            result = copyQueue.poll().name();
        }
        return result;
    }

    public String getFirstUpsetCustomer() {
        Queue<Customer> copyQueue = new LinkedList<>(queue);
        for (int i = 0; i < count && !copyQueue.isEmpty(); i++) {
            copyQueue.poll();
        }
        return copyQueue.isEmpty() ? null : copyQueue.peek().name();
    }
}
