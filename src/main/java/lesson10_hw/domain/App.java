package lesson10_hw.domain;

public class App {
    public static void main(String[] args) throws IllegalAccessException {
        Employee employee = new Employee(
                1,
                "zvon",
                "nastya",
                "pestovnikova",
                "pestov@ya.ru",
                757);

        String string = StrUtil.toString(employee);
    }
}
