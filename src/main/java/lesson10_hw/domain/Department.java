package lesson10_hw.domain;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department-id-gen")
    @SequenceGenerator(name = "department-id-gen", initialValue = 100,
            allocationSize = 5, sequenceName = "alloc_department_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private String city;

    public Department(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
