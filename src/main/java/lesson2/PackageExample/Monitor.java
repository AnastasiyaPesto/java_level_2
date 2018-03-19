package lesson2.PackageExample;

import lesson2.RandomInt;

public class Monitor {
    private String name;
    private String model;
    @RandomInt(min = 1000, max = 4300)
    private double price;

    public Monitor() {};
}
