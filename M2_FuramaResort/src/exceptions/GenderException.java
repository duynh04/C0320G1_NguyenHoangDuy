package exceptions;

import commons.Validation;

import java.util.regex.Pattern;

public class GenderException extends UserException {
    public GenderException(String message) {
        super(message);
    }

    public static String check(String input) throws GenderException {
        final String genderRegex = "^(male|female|unknown)$";
        if(!Validation.validate(genderRegex, Pattern.CASE_INSENSITIVE, input)) {
            throw new GenderException("Gender is invalid.");
        }
        input = input.toLowerCase();
        input = input.replace(input.charAt(0), Character.toUpperCase(input.charAt(0)));
        return input;
    }
}
