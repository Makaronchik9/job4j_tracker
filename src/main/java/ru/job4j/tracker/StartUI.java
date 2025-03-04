package ru.job4j.tracker;

import java.util.List;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выберите: ");
            if (select < 0 || select >= actions.size()) {
                output.println("Ошибка: некорректный ввод. Введите число от 0 до " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
        output.println("=== Завершение программы ===");
    }

    private void showMenu(List<UserAction> actions) {
        output.println("Меню:");
        for (int index = 0; index < actions.size(); index++) {
            output.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ShowAllAction(output),
                new EditAction(output),
                new DeleteAction(output),
                new FindItemByNameAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
    }
}
