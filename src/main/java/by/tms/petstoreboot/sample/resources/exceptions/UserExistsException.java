package by.tms.petstoreboot.sample.resources.exceptions;

public class UserExistsException extends RuntimeException {

    public UserExistsException() {
    }

    public UserExistsException(String message) {
        super(message);
    }


}
