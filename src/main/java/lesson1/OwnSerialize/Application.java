package lesson1.OwnSerialize;

import lesson1.Monitor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/pesto/IdeaProjects/Java2_pestovnikova/src/lesson1/OwnSerialize/monitor_ver2.txt");
        ArrayList<Monitor> monitors = OwnReadClass.readFromTXT(file);
    }
}
