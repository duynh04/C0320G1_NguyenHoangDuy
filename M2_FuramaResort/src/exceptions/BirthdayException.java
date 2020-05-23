package exceptions;

import commons.Validation;

import java.time.LocalDate;
import java.time.Period;

public class BirthdayException extends UserException{
    public BirthdayException(String message) {
        super(message);
    }

    public static void check(String input) throws BirthdayException {
        final String birthdayRegex = "^((01|[0-2][2-9]|[1-3][01])\\/(0[13578]|1[02])|([0-2][1-9]|[1-3]0)\\/(11|0[469])|([0-2][1-9]|20|10)\\/(02))\\/((19\\d{2})|([2-9]\\d{3}))$";
        if(!Validation.validate(birthdayRegex, input)) {
            throw new BirthdayException("Wrong format date: dd/MM/yyyy and year must be > 1900");
        }
        checkAge(input);
    }

    private static void checkAge(String age) throws BirthdayException {
        String[] date = age.split("/");
        if (!((Integer.parseInt(date[2]) % 4 == 0 && Integer.parseInt(date[2]) % 100 != 0) || Integer.parseInt(date[2]) % 400 == 0)) {
            if (Integer.parseInt(date[1]) == 2 && Integer.parseInt(date[0]) == 29)
                throw new BirthdayException("Customer birthday is invalid due to the 29th of february of the normal year.");
        }
        LocalDate birthDay = LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]), Integer.parseInt(date[0])); //specify year, month, date directly
        LocalDate now = LocalDate.now(); //gets localDate
        Period diff = Period.between(birthDay, now); //difference between the dates is calculated
        if (diff.getYears() < 18) {
            throw new BirthdayException("Customer mus be older than 18.");
        }
    }
}
