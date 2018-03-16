package lesson2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException,
                                                  IllegalAccessException,
                                                  InstantiationException {
        String namePackage = "lesson2.PackageExample";
        Object[] objects = RandomIntProcessor.getObjects(namePackage);

    }

}
