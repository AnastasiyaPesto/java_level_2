package lesson3.ExampleException;

public class EmptyStackException extends Exception {
    EmptyStackException(String message){
        super(message);
    }
}
