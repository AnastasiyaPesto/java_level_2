package lesson6;

import lesson6.configuration.Configuration;
import lesson6.configuration.PropertiesJdbcConfiguration;
import lesson6.dao.MySqlDepartmentDaoImpl;
import lesson6.domain.Department;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public class DaoPropertiesExample {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Configuration config = null;
        try {
            config = new PropertiesJdbcConfiguration().load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://" + config.getJdbcHost() + ":" +
                config.getJdbcPort() + "/" + config.getJdbcDatabaseName();
        if (config.getJdbcTimeZone() != null) {
            url = url + "?serverTimezone=" + config.getJdbcTimeZone();
        }
        String user = config.getJdbcUserName();
        String pasw = config.getJdbcPassword();
        try (Connection connection = DriverManager.getConnection(url, user, pasw)) {
            MySqlDepartmentDaoImpl dao = new MySqlDepartmentDaoImpl(connection);
            dao.create(7, "Driver", "Petrozavodsk");
            dao.delete(7);
            Collection<Department> departments = dao.findAll();
            Department department = dao.findById(1);
            dao.update(8, "Law", "Moscow");
       } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Подключение к базе не установлено");
        }
    }

}