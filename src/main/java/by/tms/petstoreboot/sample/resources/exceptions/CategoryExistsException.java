package by.tms.petstoreboot.sample.resources.exceptions;

public class CategoryExistsException extends RuntimeException{

    public CategoryExistsException(){

    }

    public CategoryExistsException(String message){
        super(message);
    }
}
