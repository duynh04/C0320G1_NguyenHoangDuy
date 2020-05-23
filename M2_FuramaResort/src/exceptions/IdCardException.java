package exceptions;

import commons.Validation;

public class IdCardException extends UserException {
    public IdCardException(String message) {
        super(message);
    }

    public static void check(String input) throws IdCardException {
        final String idCardRegex = "^(\\d{3}\\s?){3}$";
        if(!Validation.validate(idCardRegex, input)) {
            throw new IdCardException("ID Card must be formatted XXX XXX XXX");
        }
    }
}
