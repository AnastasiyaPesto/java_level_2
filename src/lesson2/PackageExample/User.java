package lesson2.PackageExample;

import lesson2.RandomInt;

public class User {
    private String name;
    private String surname;

    @RandomInt(min = 18, max = 55)
    private int age;

    public User() {};
}