package lesson6.ReadProperies;

public class PropertiesDB {

    private String jdbcDatabaseName;
    private String jdbcHost;
    private String jdbcPort;
    private String jdbcUserName;
    private String jdbcPassword;

    public String getJdbcTimeZone() {
        return jdbcTimeZone;
    }

    public void setJdbcTimeZone(String jdbcTimeZone) {
        this.jdbcTimeZone = jdbcTimeZone;
    }

    private String jdbcTimeZone;

    public String getJdbcDatabaseName() {
        return jdbcDatabaseName;
    }

    public void setJdbcDatabaseName(String jdbcDatabaseName) {
        this.jdbcDatabaseName = jdbcDatabaseName;
    }

    public String getJdbcHost() {
        return jdbcHost;
    }

    public void setJdbcHost(String jdbcHost) {
        this.jdbcHost = jdbcHost;
    }

    public String getJdbcPort() {
        return jdbcPort;
    }

    public void setJdbcPort(String jdbcPort) {
        this.jdbcPort = jdbcPort;
    }

    public String getJdbcUserName() {
        return jdbcUserName;
    }

    public void setJdbcUserName(String jdbcUserName) {
        this.jdbcUserName = jdbcUserName;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }
}
