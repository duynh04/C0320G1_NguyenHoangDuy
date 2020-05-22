package commons;

import exceptions.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String SERVICE_NAME_REGEX = "^[A-Z][a-z]+$";
    public static final String AREA_REGEX = "^([3-9]\\d)(\\.\\d+)?$|^([1-9][0-9]{2,})(\\.\\d+)?$";
    public static final String POSITIVE_NUMBER_REGEX = "^\\d+$";
    public static final String MAX_PEOPLE_REGEX = "^[01][1-9]|10$";
//    public static final String DATE_REGEX = "^((((01)|([0-2][2-9])|([1-3][01])\\/((0[13578])|(1[02]))))|((([0-2][1-9])|([1-3]0))\\/(11|(0[469])))|((([0-2][1-9])|(20|10))\\/(02)))\\/\\d{4}$";
    public static final String DATE_REGEX = "^((01|[0-2][2-9]|[1-3][01])\\/(0[13578]|1[02])|([0-2][1-9]|[1-3]0)\\/(11|0[469])|([0-2][1-9]|20|10)\\/(02))\\/((19\\d{2})|([2-9]\\d{3}))$";
    public static final String[] ATTACH_SERVICE = {"massage", "karaoke", "food", "drink", "car"};
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * validate for input string
     * @param regex : regex for every type.
     * @param inputStr
     * @param warningStr
     * @return a string if it validates.
     */
    public static String check(String regex, String inputStr, String warningStr) {
        String testString;
        while(true) {
            System.out.print(inputStr + ": ");
            testString = scanner.nextLine();
            if (regex.equals(""))
                return testString;
//            if(testString.matches(regex)) {
            if (validate(regex,testString)) {
                return testString;
            } else {
                System.out.println(warningStr);
            }
        }
    }

    public static String check(String type, String inputStr) {
        String testString = "";
        while (true) {
            System.out.print(inputStr + ": ");
            testString = scanner.nextLine();
            try {
                switch (type) {
                    case "Name":
                        NameException.check(testString);
                        break;
                    case "Email":
                        EmailException.check(testString);
                        break;
                    case "Birthday":
                        BirthdayException.check(testString);
                        break;
                    case "IdCard":
                        IdCardException.check(testString);
                        break;
                    case "Gender":
                        testString = GenderException.check(testString);
                        break;
                    default:
                        return testString;
                }
                return testString;
            } catch (UserException e) {
                 System.out.println(e.getMessage());
            }
        }
    }

    public static String check(String inputStr) {
        return check("", inputStr, "");
    }
    public static boolean validate(String regex, int flag, String input) {
        Pattern pattern = Pattern.compile(regex, flag);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    public static boolean validate(String regex, String input) {
        return validate(regex, 0, input);
    }
//    public static boolean validate(String input, String type) {
//        switch (type) {
//            case "Name":
//                break;
//        }
//        return true;
//    }
}
