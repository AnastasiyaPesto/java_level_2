package lesson11;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department-id-gen")
    @SequenceGenerator(name = "department-id-gen", initialValue = 100,
            allocationSize = 5, sequenceName = "alloc_department_id")
    private int departmentId;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private City city;

//    @OneToMany(targetEntity = Employee.class)
//    private Set employees;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    private Set<Employee> employees;

    public Department() {
        employees = new HashSet<>();
    }

    public int getId() {
        return departmentId;
    }

    public void setId(int id) {
        this.departmentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
