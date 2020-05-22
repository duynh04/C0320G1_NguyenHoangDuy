package exceptions;

import commons.Validation;

public class IdCardException extends UserException {
    public IdCardException(String message) {
        super(message);
    }

    public static String check(String input) throws IdCardException {
        final String idCardRegex = "^\\d{9}$";
        if(!Validation.validate(idCardRegex, input)) {
            throw new IdCardException("ID Card must be formatted XXXXXXXXX");
        }
        return input;
    }
}
