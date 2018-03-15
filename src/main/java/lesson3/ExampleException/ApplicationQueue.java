package lesson3.ExampleException;

public class ApplicationQueue {
    public static void main(String[] args) throws EmptyQueueException {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(7);
        myQueue.dequeue();
        myQueue.dequeue();
    }
}
