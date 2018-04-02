package lesson6.dao;

import lesson6.domain.Department;

import java.sql.SQLException;
import java.util.Collection;

public interface DepartmentDao {

    // insert
    Department create(int id, String name, String city) throws SQLException;

    //update
    Department update(int id, String name,String city) throws SQLException;

    //delete
    void delete(int id) throws SQLException;

    // select * from department
    // здесь переводим ResultSet в Department
    Collection<Department> findAll() throws SQLException;

    Department findById(int id) throws SQLException;
}
