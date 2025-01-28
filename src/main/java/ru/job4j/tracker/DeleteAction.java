package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int id = input.askInt("Введите id заявки для удаления: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка с id " + id + " удалена.");
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}

