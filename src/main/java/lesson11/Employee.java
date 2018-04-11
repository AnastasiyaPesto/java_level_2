package lesson11;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee-id-gen")
    @SequenceGenerator(name = "employee-id-gen", initialValue = 100,
            allocationSize = 5, sequenceName = "alloc_employee_id")
    // ALLOCTIONSIZE - СКОЛЬКО за раз достает значений
    private int id;

    @Column(length = 6, nullable = false, unique = true)
    private String login;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false, name = "last_name")
    private String lastName;

    @Column(length = 40, nullable = false)
    private String email;

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    private Department department;

    public Employee() {
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
}
