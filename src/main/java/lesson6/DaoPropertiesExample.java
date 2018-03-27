package lesson6;

import lesson6.ReadProperies.Configuration;
import lesson6.ReadProperies.ReadProperties;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoPropertiesExample {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/employyes/configdb.properties");
        try {
            Configuration config = ReadProperties.readFromProperties(file);
            String url = "jdbc:mysql://" + config.getJdbcHost() + ":" +
                    config.getJdbcPort() + "/" + config.getJdbcDatabaseName();
            if (config.getJdbcTimeZone() != null) {
                url = url + "?" + config.getJdbcTimeZone();
            }
            String user = config.getJdbcUserName();
            String pasw = config.getJdbcPassword();
            try (Connection connection = DriverManager.getConnection(url, user, pasw)) {
                int i = 0;
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Подключение к базе не установлено");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
