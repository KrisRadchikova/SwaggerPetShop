package by.tms.petstoreboot.sample.resources.exceptions;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(){

    }

    public PetNotFoundException(String message){
        super(message);
    }
}
