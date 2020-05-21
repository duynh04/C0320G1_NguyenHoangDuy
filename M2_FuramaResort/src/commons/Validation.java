package commons;

import java.util.Scanner;

public class Validation {
    public static final String SERVICE_NAME_REGEX = "^[A-Z][a-zA-Z]+$";
    public static final String AREA_REGEX = "^[3-9]\\d+(\\.\\d+)?$";
    public static final String POSITIVE_NUMBER_REGEX = "^\\d+$";
    public static final String DATE_REGEX = "^((((01)|([0-2][2-9])|([1-3][01])\\/((0[13578])|(1[02]))))|((([0-2][1-9])|([1-3]0))\\/(11|(0[469])))|((([0-2][1-9])|(20|10))\\/(02)))\\/\\d{4}$";
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
            if(testString.matches(regex)) {
                return testString;
            } else {
                System.out.println(warningStr);
            }
        }
    }

    public static String check(String inputStr) {
        return check("", inputStr, "");
    }
}
