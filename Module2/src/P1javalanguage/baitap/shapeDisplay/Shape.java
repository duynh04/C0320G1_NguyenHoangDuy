package P1javalanguage.baitap.shapeDisplay;

import java.util.Scanner;

public class Shape {
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the square triangle");
            System.out.println("3. Draw the isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Draw the rectangle");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 2:
                    System.out.println("Draw the triangle");
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    System.out.println();
                    System.out.println("*");
                    System.out.println("**");
                    System.out.println("***");
                    System.out.println("****");
                    System.out.println("*****");
                    System.out.println("******");
                    System.out.println();
                    System.out.println("     *");
                    System.out.println("    **");
                    System.out.println("   ***");
                    System.out.println("  ****");
                    System.out.println(" *****");
                    System.out.println("******");
                    System.out.println();
                    System.out.println("******");
                    System.out.println(" *****");
                    System.out.println("  ****");
                    System.out.println("   ***");
                    System.out.println("    **");
                    System.out.println("     *");
                    break;
                case 3:
                    System.out.println("Draw the isosceles triangle");
                    System.out.println("    *    ");
                    System.out.println("   ***   ");
                    System.out.println("  *****  ");
                    System.out.println(" ******* ");
                    System.out.println("*********");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
