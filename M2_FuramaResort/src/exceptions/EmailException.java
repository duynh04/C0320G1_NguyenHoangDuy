package exceptions;

import commons.Validation;

public class EmailException extends UserException{
    public EmailException(String message) {
        super(message);
    }

    public static void check(String input) throws EmailException {
        final String emailRegex = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$";
        if(!Validation.validate(emailRegex, input)) {
            throw new EmailException("Email is invalid.");
        }
    }
}
