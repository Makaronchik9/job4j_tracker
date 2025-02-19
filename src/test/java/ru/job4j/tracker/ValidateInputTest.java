package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInputThenReturnValidValue() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInputThenReturnCorrectValue() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenMultipleValidInputsThenReturnCorrectValues() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"10", "20", "30"}
        );
        ValidateInput input = new ValidateInput(output, in);

        int selected1 = input.askInt("Enter menu:");
        int selected2 = input.askInt("Enter menu:");
        int selected3 = input.askInt("Enter menu:");

        assertThat(selected1).isEqualTo(10);
        assertThat(selected2).isEqualTo(20);
        assertThat(selected3).isEqualTo(30);
    }

    @Test
    void whenNegativeInputThenReturnCorrectValue() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-5);
    }
}
