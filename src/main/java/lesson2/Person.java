package lesson2;

/**
 * @author protsko on 06.03.2018
 */
public class Person {

    @RandomInt(min = 1, max = 43)
    private int age;

    public int getAge() {
        return age;
    }

}
