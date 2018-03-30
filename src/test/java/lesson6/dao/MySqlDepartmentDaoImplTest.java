package lesson6.dao;

import lesson6.configuration.Configuration;
import lesson6.configuration.PropertiesJdbcConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MySqlDepartmentDaoImplTest {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private MySqlDepartmentDaoImpl mySqlDepartmentDao;

    @BeforeEach
    public void setup() throws IOException, SQLException {
        Configuration config = new PropertiesJdbcConfiguration().load();
        String url = "jdbc:mysql://" + config.getJdbcHost() + ":" +
                config.getJdbcPort() + "/" + config.getJdbcDatabaseName();
        if (config.getJdbcTimeZone() != null) {
            url = url + "?serverTimezone=" + config.getJdbcTimeZone();
        }
        String user = config.getJdbcUserName();
        String pasw = config.getJdbcPassword();
        try (Connection connection = DriverManager.getConnection(url, user, pasw)) {
            this.mySqlDepartmentDao = new MySqlDepartmentDaoImpl(connection);
        }
    }

    @Test
    public void testCreate_objectNotNull() {

    }

}
