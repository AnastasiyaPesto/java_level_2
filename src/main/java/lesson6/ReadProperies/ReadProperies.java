package lesson6.ReadProperies;

import java.io.*;

public class ReadProperies {

    public static PropertiesDB readFromProperties(File file) throws IOException {
        PropertiesDB propertiesDB = new PropertiesDB();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] split = line.split("=");
                if (split[0].contains("database.name")) {
                    propertiesDB.setJdbcDatabaseName(split[1]);
                    continue;
                }
                if (split[0].contains("host")) {
                    propertiesDB.setJdbcHost(split[1]);
                    continue;
                }
                if (split[0].contains("port")) {
                    propertiesDB.setJdbcPort(split[1]);
                    continue;
                }
                if (split[0].contains("username")) {
                    propertiesDB.setJdbcUserName(split[1]);
                    continue;
                }
                if (split[0].contains("password")) {
                    propertiesDB.setJdbcPassword(split[1]);
                    continue;
                }
                if (split[0].contains("time.zone")) {
                    propertiesDB.setJdbcTimeZone(split[1]);
                }
            }
        }
        return propertiesDB;
    }

}
