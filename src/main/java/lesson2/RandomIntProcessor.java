package lesson2;

import lesson2.PackageExample.Monitor;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomIntProcessor {
    public static Object[] getObjects(String basePackage) throws ClassNotFoundException,
                                                                 IllegalAccessException,
                                                                 InstantiationException {
        /**
         * new File("src\\" + basePackage.replace(".", "\\"));
         * У Maven в папке src лежит ещё папка java
         */
        File direction = new File("src\\" + basePackage.replace(".", "\\"));
        List<Class> classList = getClassesInDirectory(direction, basePackage);
        List<Object> objectList = new ArrayList<>();

        for (Class varClass : classList) {
            Object obj = varClass.newInstance();
            RandomIntProcessor.process(obj);
            objectList.add(obj);
        }

        return objectList.toArray();
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

    // Устанавливаем значение у поля, помеченного аннотацией @RandomInt
    public static void process(Object object) throws IllegalAccessException {
        final Class objectClass = object.getClass();

        // Получаем все поля класса
        final Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            final RandomInt annotation = field.getAnnotation(RandomInt.class);
            if (annotation != null) {
                int random = new Random().nextInt(annotation.max() - annotation.min()) + annotation.min();
                field.setAccessible(true);
                field.set(object, random);
            }
        }
    }


    public void nonStaticProcess(Object object) throws IllegalAccessException {
        process(object);
    }
}
