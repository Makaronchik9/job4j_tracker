package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Output output;
    private final Input input;

    public ValidateInput(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(input.askStr(question));
                break;
            } catch (NumberFormatException e) {
                output.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }
}

