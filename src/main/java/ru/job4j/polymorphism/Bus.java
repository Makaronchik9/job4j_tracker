package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус едет.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров: " + count);
    }

    @Override
    public int refuel(int fuel) {
        int fuelPrice = 50;
        int totalCost = fuel * fuelPrice;
        System.out.println("Заправлено " + fuel + " литров топлива. Стоимость заправки: " + totalCost);
        return totalCost;
    }
}