package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Изменение заявки ===");
        int id = input.askInt("Введите id заявки для замены: ");
        String name = input.askStr("Введите новое имя: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка с id " + id + " изменена на: " + item);
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}

