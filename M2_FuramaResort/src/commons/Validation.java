package commons;

public class Validation {
    public static final String NAME_SERVICE_REGEX = "^[A-Z][a-zA-Z]+$";
    public static final String AREA_REGEX = "^[3-9]\\d+(\\.\\d+)?$";
    public static final String POSITIVE_NUMBER_REGEX = "^\\d+$";
    public static final String DATE_REGEX = "^((((01)|([0-2][2-9])|([1-3][01])\\/((0[13578])|(1[02]))))|((([0-2][1-9])|([1-3]0))\\/(11|(0[469])))|((([0-2][1-9])|(20|10))\\/(02)))\\/\\d{4}$";
    public static final String[] ATTACH_SERVICE = {"massage", "karaoke", "food", "drink", "car"};
    public static boolean check() {
        return true;
    }
}
