package lesson6.dao;

import lesson6.domain.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class MySqlDepartmentDaoImpl implements DepartmentDao {

    Connection connection;

    public MySqlDepartmentDaoImpl(Connection connect) {
        this.connection = connect;
    }

    @Override
    public Department create(int id, String name, String city) throws SQLException {
        // insert into department value (id, name, city)
        String sql = "insert into department values (" + id + ", \"" + name + "\", \"" + city + "\")";

        try (Statement statement = connection.createStatement()) {
            try {
                int result = statement.executeUpdate(sql);
                System.out.println("Rows affected: " + result);
                return findById(id);
            } catch (SQLIntegrityConstraintViolationException sqlicve) {
                System.out.println("Такой первичный ключ уже существует");
            }
        }
        return findById(id);
    }

    @Override
    public Department update(int id, String name, String city) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            // update department set name = name, city = city where department_id = id;
            String sql = "update department set name = " + "\"" + name +
                    "\", city = " + "\"" + city + "\"" + "where department_id = " + id;
            int result = statement.executeUpdate(sql);
        }
        return findById(id);
    }

    @Override
    public void delete(int id) throws SQLException {
        // delete from department where department_id = id
        String sql = "delete from department where department_id = " + id;
        try (Statement statement = connection.createStatement()) {
            try {
                int delRow = statement.executeUpdate(sql);
            } catch (SQLIntegrityConstraintViolationException sqlicve) {
                System.out.println("Записи с таким первичным ключом не существует");
            }
        }
    }

    @Override
    public Collection<Department> findAll() throws SQLException {
        ArrayList<Department> departments = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from department");
            while (resultSet.next()) {
                int id = resultSet.getInt("department_id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                Department depart = new Department(id, name, city);
                departments.add(depart);
            }
            return departments;
        }
    }

    @Override
    public Department findById(int id) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String strSelectById = "select * from department where department_id = " + id ;
            ResultSet resultSet = statement.executeQuery(strSelectById);
            if (resultSet.next()) {
                int idDepart = resultSet.getInt("department_id");
                String nameDepart = resultSet.getString("name");
                String cityDepart = resultSet.getString("city");
                return new Department(idDepart, nameDepart, cityDepart);
            } else {
                return null;
            }
        }
    }
}
