package lesson1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Field;

public class ReflectionExample {
    public static void main(String[] args) throws IOException {
        Monitor monitor = new Monitor("Dell", "E2016HV", 4450);

//        Class monitorClass = monitor.getClass();
//        Field priceMonitorField = monitorClass.getDeclaredField("price");
//        priceMonitorField.setAccessible(true);
//        double price= priceMonitorField.getDouble(monitor);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Monitor.class, new WriteReadMonitorClass());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String gsonString = gson.toJson(monitor);

        File file = new File("C:/Users/pesto/IdeaProjects/Java2_pestovnikova/src/lesson1/monitor.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsolutePath()))) {
            bufferedWriter.write(gsonString);
        }
    }
}
