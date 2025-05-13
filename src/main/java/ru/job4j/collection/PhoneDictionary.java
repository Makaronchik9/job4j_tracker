package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private final List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public List<Person> find(String key) {
        Predicate<Person> byName = person -> person.getName().contains(key);

        Predicate<Person> bySurname = person -> person.getSurname().contains(key);

        Predicate<Person> byPhone = person -> person.getPhone().contains(key);

        Predicate<Person> byAddress = person -> person.getAddress().contains(key);

        Predicate<Person> combined = byName.or(bySurname).or(byPhone).or(byAddress);

        return persons.stream()
                .filter(combined)
                .collect(Collectors.toList());
    }
}
