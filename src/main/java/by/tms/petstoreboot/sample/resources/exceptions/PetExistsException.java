package by.tms.petstoreboot.sample.resources.exceptions;

public class PetExistsException extends RuntimeException{

    public PetExistsException(){

    }

    public PetExistsException(String message){
        super(message);
    }
}
