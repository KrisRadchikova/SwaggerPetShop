package by.tms.petstoreboot.sample.resources.exceptions;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(){

    }

    public CategoryNotFoundException(String message){
        super(message);
    }
}

