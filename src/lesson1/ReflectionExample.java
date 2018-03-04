package lesson1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Field;

public class ReflectionExample {
    public static void main(String[] args) throws IOException {
        Monitor monitorToFile = new Monitor("Dell", "E2016HV", 4450);
        Monitor monitorFromFile = new Monitor();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Monitor.class, new WriteReadMonitorClass());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String gsonString = gson.toJson(monitorToFile);

        File file = new File("C:/Users/pesto/IdeaProjects/Java2_pestovnikova/src/lesson1/monitor.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsolutePath()))) {
            bufferedWriter.write(gsonString);
        }

        JsonReader reader = new JsonReader(new FileReader(file));
        monitorFromFile = gson.fromJson(reader, Monitor.class);
    }
}
