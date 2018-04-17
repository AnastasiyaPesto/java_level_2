package lesson10_hw.domain;

import com.sun.org.apache.xerces.internal.xs.StringList;

public class App {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {
        Employee employee = new Employee(
                1,
                "zvon",
                "nastya",
                "pestovnikova",
                "pestov@ya.ru",
                757);

        EmployeeInfo employeeInfo = new EmployeeInfo(employee.getId(), 26, "prog", false, "888-999-22");
        employee.setEmployeeInfo(employeeInfo);

        Employee employee1 = new Employee();

        String string = StrUtil.toString(employee1);
        System.out.println(string);
    }
}
