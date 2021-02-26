package by.tms.petstoreboot.sample.service;

public class UserExistsException extends RuntimeException{

    public UserExistsException(){
    }

    public UserExistsException(String message){
        super(message);
    }
}
