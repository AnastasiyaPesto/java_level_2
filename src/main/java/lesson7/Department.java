package lesson7;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name", unique = true, nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    public Department() {}

    public Department(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
