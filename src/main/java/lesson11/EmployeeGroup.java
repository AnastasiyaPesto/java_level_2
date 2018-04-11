package lesson11;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employeeGroup")
public class EmployeeGroup {
    private int employeeId;
    private int groupId;

    public EmployeeGroup(int employeeId, int groupId) {
        this.employeeId = employeeId;
        this.groupId = groupId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
