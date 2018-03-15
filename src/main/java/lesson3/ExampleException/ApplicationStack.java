package lesson3.ExampleException;

public class ApplicationStack {
    public static void main(String[] args) throws EmptyStackException {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(5);
        myStack.pop();
        myStack.pop();
    }
}
