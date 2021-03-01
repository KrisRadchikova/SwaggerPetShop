package by.tms.petstoreboot.sample.resources.exceptions;

public class InvalidIDSuppliedException extends RuntimeException {

   public InvalidIDSuppliedException(){

   }

   public InvalidIDSuppliedException(String message){
      super(message);
   }
}
