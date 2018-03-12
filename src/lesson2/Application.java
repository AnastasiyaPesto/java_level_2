package lesson2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException {

        String namePackage = "lesson2";

        File direction = new File("src\\" + namePackage.replace(".", "\\"));

        List<Class> classes = getClassesInDirectory(direction, namePackage);

    }

    private static List<Class> getClassesInDirectory(File dir, String namePackage) throws ClassNotFoundException {
        List<Class> listClass = new ArrayList<>();
        File[] files = dir.listFiles();

        if (files == null) return listClass;

        for (File file : files) {
            if (file.isDirectory()) {
                listClass.addAll(getClassesInDirectory(file, namePackage + "." + file.getName()));
            } else if (file.getName().endsWith(".java")) {
                listClass.add(Class.forName(namePackage + "." + file.getName().replace(".java", "")));
            }
        }

        return listClass;
    }

}
