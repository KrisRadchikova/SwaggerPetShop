package by.tms.petstoreboot.sample.service;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
