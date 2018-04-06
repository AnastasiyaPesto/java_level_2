package lesson2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

public class RandomIntProcessorTest {

    // объект, через кторый будем тестировать нужный класс RandomIntProcessor
    private RandomIntProcessor randomIntProcessor;

    // 1. Запускается в самом начале
    // 2. Запускается только один раз
    @BeforeAll
    public static void once() {
        System.out.println("Before all");
    }

    // 1. Запускается перед каждым тестом (методом, который помечен @Test)
    @BeforeEach
    public void setup() {
        // если создавать объект перед каждым запуском теста, то тесты будут независимы
        this.randomIntProcessor = new RandomIntProcessor();
        System.out.println("Setup");
    }

    @Test
    @RepeatedTest(100)
    public void testNonStaticProcess() throws IllegalAccessException {
        Person person = new Person();
        randomIntProcessor.nonStaticProcess(person);

        int age = person.getAge();
        Assertions.assertTrue(age >= 1 && age < 43);
    }

    @Test
    public void testNonStaticProcess_objectNull() throws IllegalAccessException {
        Assertions.assertThrows(
                NullPointerException.class,
                // Анонимный внутренний класс
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        randomIntProcessor.nonStaticProcess(null);
                    }
                }
//                ()->{
//                    randomIntProcessor.nonStaticProcess(null);
//                }
        );
    }

    // Запускается после выполнения теста (после отработки тестового метода)
    @AfterEach
    public void tearDown() {
        System.out.println("Tear down");
    }

    // Запускается после выполения всех тестов (только один раз)
    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }
}
