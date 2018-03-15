package lesson3;

public class StringUtil {
    // Строка пустая, если:
    // 1. null
    // 2. ""
    // 3. состоит из одних пробелов ("     ")
    public static boolean isEmpty(String value) {
        // "     sdf     " => после trim() будет "sdf"
        // "   qwerty and    " => trim() => "qwerty and"
        return (value == null || value.trim().isEmpty());
    }
}
