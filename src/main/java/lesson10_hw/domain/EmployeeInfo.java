package lesson10_hw.domain;

import javax.persistence.*;

@Entity
@Table(name = "employeeInfo")
public class EmployeeInfo {
    @Id
    @Column(name = "employee_id")
    private int employeeId;

    @Column
    private int age;

    @Column(length = 40, nullable = false)
    private String position;

    @Column
    private boolean sex;

    @Column(length = 40)
    private String internalTelephone;
}
