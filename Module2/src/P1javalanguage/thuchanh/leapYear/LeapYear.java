package P1javalanguage.thuchanh.leapYear;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a year: ");
        int year = Integer.parseInt(scanner.nextLine());
        if(checkLeapyear(year)) {
            System.out.printf("%d is a leap year", year);
        } else
            System.out.printf("%d is not a leap year", year);
    }
    public static boolean checkLeapyear(int year) {
       if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
           return true;
       }
       return false;
    }
}
