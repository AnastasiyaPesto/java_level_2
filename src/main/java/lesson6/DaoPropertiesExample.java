package lesson6;

import lesson6.ReadProperies.PropertiesDB;
import lesson6.ReadProperies.ReadProperies;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;

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
            PropertiesDB propDB = ReadProperies.readFromProperties(file);
            String url = "jdbc:mysql://" + propDB.getJdbcHost() + ":" +
                    propDB.getJdbcPort() + "/" + propDB.getJdbcDatabaseName();
            if (propDB.getJdbcTimeZone() != null) {
                url = url + "?" + propDB.getJdbcTimeZone();
            }
            String user = propDB.getJdbcUserName();
            String pasw = propDB.getJdbcPassword();
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
