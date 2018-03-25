package lesson6;

import java.sql.*;

public class MySqlExample {

    // Нам нужно загрузить драйвер ДО загрузки класса MySqlExample
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // пробросили системное исключение через unchecked исключение.
            // если оно словится, то класс не загрузится (работа окончится)
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // connection url
        // 127.0.0.1 = localhost (C:\Windows\System32\drivers\etc)
        // port - порт сервера
        // jdbc:<database vendor>://<ip>:<port>/<database_name>
        // "jdbc:mysql://127.0.0.1:3306/employees?createDatabaseIfNotExists=true
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/employees?serverTimezone=UTC",
                    "root",
                    "root"
        );
             Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String login = resultSet.getString("login");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                int departmentId = resultSet.getInt("department_id");
                System.out.println("employee_id: " + employeeId + "\n" +
                                    "login: " + login + "\n" +
                                    "name: " + name + "\n" +
                                    "last_name: " + lastName + "\n" +
                                    "email : " + email + "\n" +
                                    "department_id: " + departmentId + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
