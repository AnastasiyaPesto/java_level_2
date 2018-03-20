package lesson1.OwnSerialize;

import lesson1.Monitor;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class OwnReadClass {

    public static ArrayList<Monitor> readFromTXT(File file) throws IOException {
        ArrayList<Monitor> monitors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(",");
                Monitor currentMonitor = new Monitor();
                try {
                    Class monitorClass = currentMonitor.getClass();
                    Field nameMonitor = monitorClass.getDeclaredField("name");
                    setField(nameMonitor, currentMonitor, array[0]);

                    Field modelMonitor = monitorClass.getDeclaredField("model");
                    setField(modelMonitor, currentMonitor, array[1]);

                    Field priceMonitor = monitorClass.getDeclaredField("price");
                    setField(priceMonitor, currentMonitor, Integer.parseInt(array[2]));
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
                monitors.add(currentMonitor);
            }
        }
        return monitors;
    }

    public static void setField(Field field, Object object, Object data) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(object, data);
    }
}
