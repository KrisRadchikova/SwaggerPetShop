package by.tms.petstoreboot.sample.resources.exceptions;

public class InvalidStatusValueException extends RuntimeException {

   public InvalidStatusValueException(){

   }

   public InvalidStatusValueException(String message){
       super(message);
   }
}
