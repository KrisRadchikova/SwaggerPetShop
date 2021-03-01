package by.tms.petstoreboot.sample.resources.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(){

    }

    public OrderNotFoundException(String message){
        super(message);
    }
}
