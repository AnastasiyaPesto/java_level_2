package lesson3;

import lesson3.ExampleException.MyStack;
import lesson3.ExampleException.StackOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Random;

public class MyStackTest {

    private MyStack<Integer> myStack;

    @BeforeEach
    public void setMyStack() {
        this.myStack = new MyStack<>(5);
    }

    @Test
    public void testPop () {
        myStack.pop();
    }

    @Test
    public void testPush() throws StackOverflowException {
        Random elem = new Random();
        Assertions.assertThrows(
                StackOverflowException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        for (int i = 0; i <= myStack.getCap(); i++) {
                            myStack.push(elem.nextInt(10));
                        }
                    }
                }
        );
    }
}
