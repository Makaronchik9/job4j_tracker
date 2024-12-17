package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    private final Scanner scanner;
    private final Tracker tracker;

    public StartUI(Scanner scanner, Tracker tracker) {
        this.scanner = scanner;
        this.tracker = tracker;
    }

    public void init() {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = -1;
            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Пожалуйста, введите число.");
                continue;
            }

            if (select == 0) {
                System.out.println("=== Создание новой заявки ===");
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Вывод всех заявок ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("=== Редактирование заявки ===");
                System.out.print("Введите id: ");
                int id = -1;
                try {
                    id = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода! Пожалуйста, введите корректный id.");
                    continue;
                }

                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                Item item = new Item(name);

                if (tracker.replace(id, item)) {
                    System.out.println("Заявка изменена успешно.");
                } else {
                    System.out.println("Ошибка замены заявки. Заявка с таким id не найдена.");
                }
            } else if (select == 6) {
                System.out.println("Выход из программы.");
                run = false;
            } else {
                System.out.println("Некорректный выбор! Пожалуйста, выберите правильный пункт меню.");
            }
        }
    }

    public void showMenu() {
        System.out.println("Меню:");
        System.out.println("0. Добавить заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("6. Выход");
    }
}
