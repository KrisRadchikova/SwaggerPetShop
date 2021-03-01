package by.tms.petstoreboot.sample.resources.exceptions;

public class ValidationException extends RuntimeException {

   public ValidationException(){

   }

   public ValidationException(String message){
       super(message);
   }
}
