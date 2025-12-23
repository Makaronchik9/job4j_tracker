package ru.job4j.tracker;

import java.time.LocalDateTime;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Редактировать заявку";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Введите id заявки: ");
        String name = input.askStr("Введите новое имя: ");
        Item newItem = new Item(id, name, LocalDateTime.now());
        if (tracker.replace(id, newItem)) {
            output.println("Заявка успешно изменена.");
        } else {
            output.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}

