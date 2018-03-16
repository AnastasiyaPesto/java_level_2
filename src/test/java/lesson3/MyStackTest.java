package lesson3;

import lesson3.ExampleException.EmptyStackException;
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
        this.myStack = new MyStack<>(3);
    }

    @Test
    public void testPopWhenStackIsEmpty_throwEmptyStackException () {
        Assertions.assertThrows(
                EmptyStackException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        myStack.pop();
                    }
                }
        );
    }

    @Test
    public void testPeekWhenStackIsEmpty_testPopWhenStackIsEmpty_throwEmptyStackException() {
        Assertions.assertThrows(
                EmptyStackException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        myStack.peek();
                    }
                }
        );
    }

    @Test
    public void testPushFiveIntegerWhenCapIsThree_throwStackOverflowException() throws StackOverflowException {
        Assertions.assertThrows(
                StackOverflowException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        pushObjectInStack(8, 9, -1, 45, 8);
                    }
                }
        );
    }

    private void pushObjectInStack(Integer... integers) throws StackOverflowException {
        for (Integer integer : integers) {
            myStack.push(integer);
        }
    }
}
