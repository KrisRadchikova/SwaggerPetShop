package by.tms.petstoreboot.sample.resources.exceptions;

public class InvalidOrderException extends RuntimeException {

    public InvalidOrderException(){

    }

    public InvalidOrderException(String message){
        super(message);
    }
}
