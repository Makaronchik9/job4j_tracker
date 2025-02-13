package ru.job4j.tracker;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class StartUITest {

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(output)
        };

        new StartUI(output).init(input, tracker, actions);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    class MockInput implements Input {
        private final String[] answers;
        private int position = 0;

        public MockInput(String[] answers) {
            this.answers = answers;
        }

        @Override
        public String askStr(String question) {
            if (position >= answers.length) {
                throw new ArrayIndexOutOfBoundsException("Попытка обращения к answers[" + position + "], но размер массива " + answers.length);
            }
            return answers[position++];
        }

        @Override
        public int askInt(String question) {
            return Integer.parseInt(askStr(question));
        }
    }

    class StubOutput implements Output {
        private final StringBuilder output = new StringBuilder();

        @Override
        public void println(Object obj) {
            output.append(obj).append(System.lineSeparator());
        }

        @Override
        public String toString() {
            return output.toString();
        }
    }

    class ExitAction implements UserAction {
        private final Output output;

        public ExitAction(Output output) {
            this.output = output;
        }

        @Override
        public String name() {
            return "Завершить программу";
        }

        @Override
        public boolean execute(Input input, Tracker tracker) {
            output.println("=== Завершение программы ===");
            return false;
        }
    }
}
