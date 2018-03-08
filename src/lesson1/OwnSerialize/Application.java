package lesson1.OwnSerialize;

import lesson1.Monitor;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        File file = new File("C:/Users/pesto/IdeaProjects/Java2_pestovnikova/src/lesson1/OwnSerialize/monitor_ver2.txt");
        Monitor[] monitors = OwnReadClass.readFromTXT(file);
    }
}
