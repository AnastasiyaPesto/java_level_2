package lesson6.configuration;

import java.io.*;

public class PropertiesJdbcConfiguration implements JdbcConfiguration {
    @Override
    public Configuration load() throws IOException {
        Configuration configuration = new Configuration();
        String path = "src/main/resources/employyes/configdb.properties";
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] split = line.split("=");
                if (split[0].contains("database.name")) {
                    configuration.setJdbcDatabaseName(split[1]);
                    continue;
                }
                if (split[0].contains("host")) {
                    configuration.setJdbcHost(split[1]);
                    continue;
                }
                if (split[0].contains("port")) {
                    configuration.setJdbcPort(split[1]);
                    continue;
                }
                if (split[0].contains("username")) {
                    configuration.setJdbcUserName(split[1]);
                    continue;
                }
                if (split[0].contains("password")) {
                    configuration.setJdbcPassword(split[1]);
                    continue;
                }
                if (split[0].contains("time.zone")) {
                    configuration.setJdbcTimeZone(split[1]);
                }
            }
        }
        return configuration;
    }
}
