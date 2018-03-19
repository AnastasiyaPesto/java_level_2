package lesson3;

import lesson3.ExampleException.EmptyStackException;
import lesson3.ExampleException.MyStack;
import lesson3.ExampleException.StackOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javax.swing.*;
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
    public void testPeekWhenStackIsEmpty_throwEmptyStackException() {
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

    @Test
    public void testPush_newInteger_returnTrue() throws StackOverflowException {
        Integer integer = 7;
        int oldSize = myStack.getSize();
        myStack.push(integer);
        int newSize = myStack.getSize();
        Assertions.assertTrue(oldSize < newSize);
    }

    @Test
    public void testPop_returnObjectAndChangeSize() throws StackOverflowException, EmptyStackException {
        pushObjectInStack(0, 1, 2);
        int oldSize = myStack.getSize();
        Integer integer = myStack.pop();
        int newSize = myStack.getSize();
        Assertions.assertNotNull(integer);
        Assertions.assertTrue(newSize < oldSize);
    }

    @Test
    public void testPeek_returnObjectAndNotChangeSize() throws StackOverflowException, EmptyStackException {
        pushObjectInStack(0, 1, 2);
        int oldSize = myStack.getSize();
        Integer integer = myStack.peek();
        int newSize = myStack.getSize();
        Assertions.assertNotNull(integer);
        Assertions.assertTrue(oldSize == newSize);
    }
}
