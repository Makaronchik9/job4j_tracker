package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Original item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "Updated item"
        };
        StartUI.replaceItem(new MockInput(answers), tracker);
        Item updated = tracker.findById(item.getId());
        assertThat(updated.getName()).isEqualTo("Updated item");
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Item to delete");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        StartUI.deleteItem(new MockInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted).isNull();
    }
}