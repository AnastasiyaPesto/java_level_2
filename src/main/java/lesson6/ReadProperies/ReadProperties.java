package lesson6.ReadProperies;

import java.io.*;

public class ReadProperties {

    public static Configuration readFromProperties(File file) throws IOException {
        Configuration configuration = new Configuration();

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
