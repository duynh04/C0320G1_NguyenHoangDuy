package exceptions;


import commons.Validation;

public class NameException extends UserException {
    public NameException(String message) {
        super(message);
    }

    public static void check(String input) throws NameException {
        final String outerSpaceRegex = "^\\s+([A-Za-z]+\\s*)+\\s*$";
        final String nameRegex = "^([A-Z][a-z]+\\s?)+$";
        // check outer space

        if(Validation.validate(outerSpaceRegex, input)) {
            throw new NameException("Not valid Name, please try again.");
        } else {
            //check valid name
            input = input.trim();
            if(!Validation.validate(nameRegex, input)) {
                throw new NameException("Not valid Name, please try again.!");
            }
        }
    }
}
