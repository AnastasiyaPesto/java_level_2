package lesson3.ExampleException;

public class EmptyQueueException extends Exception {
    EmptyQueueException(String message){
        super(message);
    }
}
