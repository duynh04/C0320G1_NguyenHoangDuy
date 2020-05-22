package exceptions;

import commons.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class BirthdayException extends UserException{
    public BirthdayException(String message) {
        super(message);
    }

    public static String check(String input) throws BirthdayException {
        final String birthdayRegex = "^((01|[0-2][2-9]|[1-3][01])\\/(0[13578]|1[02])|([0-2][1-9]|[1-3]0)\\/(11|0[469])|([0-2][1-9]|20|10)\\/(02))\\/((19\\d{2})|([2-9]\\d{3}))$";
        if(!Validation.validate(birthdayRegex, input)) {
            throw new BirthdayException("Wrong fomat date: dd/MM/yyyy and year must be > 1900");
        }
        checkAge(input);
        return input;
    }

    private static void checkAge(String age) throws BirthdayException {
        String[] date = age.split("/");
        LocalDate birthDay = LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]), Integer.parseInt(date[0])); //specify year, month, date directly
        LocalDate now = LocalDate.now(); //gets localDate
        Period diff = Period.between(birthDay, now); //difference between the dates is calculated
        if (diff.getYears() < 18) {
            throw new BirthdayException("Customer mus be older than 18.");
        }
    }
}
