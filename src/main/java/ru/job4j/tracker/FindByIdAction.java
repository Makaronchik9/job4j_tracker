package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Показать заявку по id ===");
        int id = input.askInt("Введите id заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Найденная заявка: " + item);
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}

