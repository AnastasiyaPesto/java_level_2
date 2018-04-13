package lesson10_hw.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class StrUtil {
    public static String toString(Object object) throws IllegalAccessException, ClassNotFoundException {
        Class classObject = object.getClass();
        Field[] fields = classObject.getDeclaredFields();
        String nameField;
        String valueField;
        String result = "";
        for (Field field : fields) {
            String typeField = field.getType().toString();

            if (typeField.contains("String")) {
                typeField = "String";
            }

            if (isPrimitiveOrString(typeField)){
                field.setAccessible(true);
                nameField = field.getName();
                valueField = field.get(object).toString();
                result = result + nameField + " = " + valueField + ", ";
            } else {
                // result = toString(field.get());
            }
        }
        return result;
    }

    public static boolean isPrimitiveOrString(String str) {
        return setPrimitiveAndStringType().contains(str);
    }

    private static Set<String> setPrimitiveAndStringType() {
        Set<String> primitiveTypeSet = new HashSet<>();

        primitiveTypeSet.add("byte");
        primitiveTypeSet.add("char");
        primitiveTypeSet.add("short");
        primitiveTypeSet.add("int");
        primitiveTypeSet.add("long");
        primitiveTypeSet.add("double");
        primitiveTypeSet.add("float");
        primitiveTypeSet.add("boolean");
        primitiveTypeSet.add("String");

        return primitiveTypeSet;
    }
}
