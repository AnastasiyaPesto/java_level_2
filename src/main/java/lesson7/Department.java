package lesson7;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @Column(name = "D_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name", unique = true, nullable = false)
    private String name;

    @OneToOne(mappedBy = "department")
    private DepartmentInfo info;

    public DepartmentInfo getInfo() {
        return info;
    }

    public void setInfo(DepartmentInfo info) {
        this.info = info;
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

    @Column(name = "city", nullable = false)

    private String city;

    public Department() {}

    public Department(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
