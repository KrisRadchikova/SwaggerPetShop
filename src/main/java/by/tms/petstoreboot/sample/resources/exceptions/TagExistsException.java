package by.tms.petstoreboot.sample.resources.exceptions;

public class TagExistsException extends RuntimeException{

    public TagExistsException(){

    }

    public TagExistsException(String message){
        super(message);
    }
}
