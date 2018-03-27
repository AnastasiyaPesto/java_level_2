package lesson6.dao;

import lesson6.domain.Department;

import java.sql.*;
import java.util.Collection;

public class MySqlDepartmentDaoImpl implements DepartmentDao {

    Connection connection;

    public MySqlDepartmentDaoImpl(Connection connect) {
        this.connection = connect;
    }

    @Override
    public Department create(int id, String name, String city) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/employees?serverTimezone=UTC",
                "root",
                "root"
        )) {
            // insert into department value (id, name, city)
            String sql = "insert into department value (" + id + ", " + name + ", " + city + ")";

            Statement statement = connection.createStatement();

            int result = statement.executeUpdate(sql);
            System.out.println("Rows affected: " + result);
            // TODO: get department
        }
        return null;
    }

        @Override
    public Department update(int id, String name, String city) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Collection<Department> findAll() {
        return null;
    }

    @Override
    public Department findById(int id) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String strSelectById = "select * from department where department_id = 0";
            ResultSet resultSet = statement.executeQuery(strSelectById);
        }

        return null;
    }
}
