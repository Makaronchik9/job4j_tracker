package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();

        Item item1 = new Item("First Item");
        Item item2 = new Item("Second Item");
        Item item3 = new Item("First Item");

                tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

                System.out.println("All items:");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }

                System.out.println("\nFind by ID (1):");
        Item foundById = tracker.findById(1);
        System.out.println(foundById != null ? foundById : "Item not found");

                System.out.println("\nFind by name ('First Item'):");
        for (Item item : tracker.findByName("First Item")) {
            System.out.println(item);
        }
    }
}