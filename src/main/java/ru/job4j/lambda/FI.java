package ru.job4j.lambda;

import java.util.*;

public class FI {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Petr", "Ivan", "Stepan");

        names.sort((left, right) -> left.compareTo(right));
        System.out.println("По алфавиту: " + names);

        names.sort((left, right) -> Integer.compare(right.length(), left.length()));
        System.out.println("По убыванию длины: " + names);
    }
}
