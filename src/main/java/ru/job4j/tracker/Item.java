package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String name;

    // Конструктор
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттер для ID
    public int getId() {
        return id;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Сеттер для ID
    public void setId(int id) {
        this.id = id;
    }
}