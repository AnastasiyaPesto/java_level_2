package lesson3.ExampleException;

import lesson3.ExampleException.EmptyStackException;
import lesson3.ExampleException.MyCollection;

public class MyStack<T> implements MyCollection {

    class StackElement {
        // ссылка на следующий элемент списка
        StackElement next;
        // значение
        T value;
        StackElement(T value) {
            this.value = value;
        }
    }
    private StackElement head;
    private int realSize;
    private int cap;

    public MyStack(int cap){
        this.cap = cap;
        this.realSize = 0;
    }

    public boolean push(T value) throws StackOverflowException {
        StackElement elemStack = new StackElement(value);
        if (realSize == cap) {
            throw new StackOverflowException("Переполнение стека");
        }
        if(head == null){
            head = elemStack;
        } else {
            elemStack.next = head;
            head = elemStack;
        }
        realSize++;
        return true;
    }

    public T pop() throws EmptyStackException {
        T retVal = null;

        if(realSize == 0) {
            throw new EmptyStackException("Стек пустой. Удалять больше нечего");
        }else{
            if (head.next == null){
                retVal = head.value;
                head = null;
                realSize--;
            } else {
                retVal = head.value;
                head = head.next;
                realSize--;
            }
        }
        return retVal;
    }

    public T peek() throws EmptyStackException {
        if (realSize == 0) {
            throw new EmptyStackException("Stack is empty");
        }
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return (realSize == 0);
    }

    public int getCap() {
        return cap;
    }

    @Override
    public int getSize() {
        return realSize;
    }

    @Override
    public Object[] toArray() {
        T[] array = (T[])(new Object[realSize]);
        StackElement current = head;
        int index = 0;
        while(current != null){
            array[index] = current.value;
            current = current.next;
            index++;
        }
        return array;
    }
}
