package lesson6.configuration;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface JdbcConfiguration {
    Configuration load() throws IOException;
}
