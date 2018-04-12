package lesson10_hw.domain;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee-id-gen")
    @SequenceGenerator(name = "employee-id-gen", initialValue = 100,
            allocationSize = 5, sequenceName = "alloc_employee_id")
    private int id;

    @Column(length = 6, nullable = false, unique = true)
    private String login;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String lastName;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(nullable = false, name = "department_id")
    private int departmentId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeInfo employeeInfo;

    public Employee(int id, String login, String name, String lastName, String email, int department_id) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.departmentId = department_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartment_id() {
        return departmentId;
    }

    public void setDepartment_id(int department_id) {
        this.departmentId = department_id;
    }
}
