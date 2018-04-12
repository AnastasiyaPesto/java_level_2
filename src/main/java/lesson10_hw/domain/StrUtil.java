package lesson10_hw.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class StrUtil {
    public static String toString(Object object) throws IllegalAccessException {
        Class classObject = object.getClass();
        Field[] fields = classObject.getDeclaredFields();
        String nameField;
        String valueField;
        String result = "";
        for (Field f : fields) {
            Object typeField = f.getType();

            if (!(typeField.getClass() instanceof Object)){

                f.setAccessible(true);
                nameField = f.getName();
                valueField = f.get(object).toString();
                result = result + nameField + " = " + valueField + ", ";
            }

        }
        return result;
    }
}
