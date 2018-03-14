package lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Класс можно назвать TestStringUtil
 */
public class StringUtilTest {

    // правило написания имени метода теста: testIsEmpty_nullString_returnTrue
    // если передадим nullString, то получим True

    // @Test для того, чтобы библиотека jupiter поняла, что это тестовы метод
    @Test
    public void testIsEmpty_nullString_returnTrue() {
        boolean result = lesson3.StringUtil.isEmpty(null);
        // assert - ждать
        Assertions.assertTrue(result); // если передаем True, то тест не упадет
    }

}
