package P1javalanguage.thuchanh.daysInMonth;

import java.util.Scanner;

public class DayInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which month that you want to count days?");
        int month = scanner.nextInt();
        System.out.println(countDays(month));
    }
    public static String countDays(int month) {
        String temp = "";
        switch (month) {
            case 2:
                temp =  "The month has 28 or 29 days";
                break;
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                temp = "The month " + month + " has 31 days";
                break;
            case 4: case 6: case 9: case 11:
                temp = "The month " + month + " has 30 days";
                break;
            default:
                temp = "The month must be from 1 to 12";
        }
        return temp;
    }
}
