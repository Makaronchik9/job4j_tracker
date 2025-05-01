package ru.job4j.collection;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var combine = (Predicate<Person>) p -> p.getName().contains(key)
                || p.getPhone().contains(key)
                || p.getAddress().contains(key)
                || p.getSurname().contains(key);
        return persons.stream()
                .filter(combine)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
