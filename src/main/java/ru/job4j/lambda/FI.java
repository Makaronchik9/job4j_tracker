package ru.job4j.lambda;

import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);

        Comparator<String> comparatorDescSize = (left, right) ->
                Integer.compare(right.length(), left.length());
    }
}
