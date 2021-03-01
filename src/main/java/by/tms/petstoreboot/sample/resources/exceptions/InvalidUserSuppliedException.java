package by.tms.petstoreboot.sample.resources.exceptions;

public class InvalidUserSuppliedException extends RuntimeException{

    public InvalidUserSuppliedException(){

    }

    public InvalidUserSuppliedException(String message){
        super(message);
    }
}
