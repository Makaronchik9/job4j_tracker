package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Old name"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "New name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("New name");
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item to delete"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }
}


