package lesson11;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeInfo")
public class EmployeeInfo {
    @Column
    private int age;

    @Column(length = 40, nullable = false)
    private String position;

    @Column
    private boolean sex;

    @Column(length = 40)
    private String internalTelephone;

    @Id
    @Column
    private int employeeId;
}
