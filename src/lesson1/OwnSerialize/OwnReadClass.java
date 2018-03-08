package lesson1.OwnSerialize;

import lesson1.Monitor;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class OwnReadClass {
    static Monitor[] monitors;

    public static Monitor[] readFromTXT(File file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            ArrayList<String> strings = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                char[] arrayChar = line.toCharArray();
                int i = 0;
                while (i < arrayChar.length) {
                    if (arrayChar[i] != ',') {
                        stringBuilder.append(arrayChar[i]);
                    } else {
                        strings.add(stringBuilder.toString());
                        stringBuilder.setLength(0);
                    }
                    i++;
                }
                strings.add(stringBuilder.toString());
            }
            int countMonitor = strings.size() / 3;
            int j = 0;
            monitors = new Monitor[countMonitor];
            for (int i = 0; i < strings.size(); i = i + 3) {
                String name = strings.get(i);
                String model = strings.get(i + 1);
                int price = Integer.parseInt(strings.get(i + 2));
                monitors[j] = new Monitor();
                Class monitorClass = monitors[j].getClass();
                try {
                    Field nameMonitor = monitorClass.getDeclaredField("name");
                    Field modelMonitor = monitorClass.getDeclaredField("model");
                    Field priceMonitor = monitorClass.getDeclaredField("price");
                    nameMonitor.setAccessible(true);
                    nameMonitor.set(monitors[j], name);
                    modelMonitor.setAccessible(true);
                    modelMonitor.set(monitors[j], model);
                    priceMonitor.setAccessible(true);
                    priceMonitor.set(monitors[j], price);
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return monitors;
    }
}
