package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item newItem = new Item(id, name);
        if (tracker.replace(id, newItem)) {
            output.println("Item replaced successfully.");
        } else {
            output.println("Item not found.");
        }
        return true;
    }
}