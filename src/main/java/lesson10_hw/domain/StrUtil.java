package lesson10_hw.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StrUtil {
    public static String toString(Object object) throws IllegalAccessException, ClassNotFoundException {
        if (object == null) {
            return "";
        }
        Class classObject = object.getClass();
        Field[] fields = classObject.getDeclaredFields();
        List<String> stringList = new ArrayList<>();
        for (Field field : fields) {
            Class typeField = field.getType();
            field.setAccessible(true);
            if (typeField.isPrimitive()) {
                stringList.add(field.getName() + " = " + field.get(object).toString());
            } else if (typeField.equals(String.class)) {
                String str = field.getName();
                if (field.get(object) != null) {
                    stringList.add(field.getName() + " = " + field.get(object).toString());
                } else {
                    stringList.add(field.getName() + " = \" \" ");
                }
            }
            else {
                Object ob = field.get(object);
                if (ob != null) {
                    stringList.add(toString(ob));
                }
            }
        }
        return String.join(", ", stringList);
    }
}
