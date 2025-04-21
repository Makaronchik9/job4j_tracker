package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemSorterTest {

    @Test
    void whenSortAscByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Banana"),
                new Item(2, "Apple"),
                new Item(3, "Orange")
        );
        List<Item> expected = Arrays.asList(
                new Item(2, "Apple"),
                new Item(1, "Banana"),
                new Item(3, "Orange")
        );
        Collections.sort(items, new ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Banana"),
                new Item(2, "Apple"),
                new Item(3, "Orange")
        );
        List<Item> expected = Arrays.asList(
                new Item(3, "Orange"),
                new Item(1, "Banana"),
                new Item(2, "Apple")
        );
        Collections.sort(items, new ItemDescByName());
        assertEquals(expected, items);
    }
}
