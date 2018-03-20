package lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Класс можно назвать TestStringUtil
 */

// иногда пишут public private class - чтобы не переопределять
public class StringUtilTest {

    // private - не надо создавать объекты этого класса, т.к. тут и так все методы public
    private StringUtilTest() {

    };
    // правило написания имени метода теста: testIsEmpty_nullString_returnTrue
    // если передадим nullString, то получим True

    // @Test для того, чтобы библиотека jupiter поняла, что это тестовы метод
    @Test
    public void testIsEmpty_nullString_returnTrue() {
        boolean result = StringUtil.isEmpty(null);
        // assert - ждать
        Assertions.assertTrue(result); // если передаем True, то тест не упадет
    }

}
