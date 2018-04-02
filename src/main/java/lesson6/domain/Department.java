package lesson6.domain;

public class Department {

    private int departmentId;
    private String name;
    private String city;

    public Department(int departnmentId, String name, String city) {
        this.departmentId = departnmentId;
        this.name = name;
        this.city = city;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
