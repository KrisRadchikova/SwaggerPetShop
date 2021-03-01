package by.tms.petstoreboot.sample.resources.exceptions;

public class InvalidUserNameOrPasswordSuppliedException extends RuntimeException {

    public InvalidUserNameOrPasswordSuppliedException(){

    }

    public InvalidUserNameOrPasswordSuppliedException(String message){
        super(message);
    }
}
