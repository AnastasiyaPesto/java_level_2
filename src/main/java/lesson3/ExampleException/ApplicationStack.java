package lesson3.ExampleException;

public class ApplicationStack {
    public static void main(String[] args) throws EmptyStackException, StackOverflowException {
        MyStack<Integer> myStack = new MyStack<>(10);
        myStack.push(5);
        myStack.pop();
        myStack.pop();
    }
}
