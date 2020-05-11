package P2ArrayAndMethod.baitap.countRepitition;

import java.util.Scanner;

public class Repitition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a string ");
        String str = scanner.nextLine();
        System.out.print("Input a character ");
        char c = scanner.nextLine().charAt(0);
        // count the repitition
        int counter = countRepitition(str, c);
        System.out.printf("There are %d character %c in \"%s\"", counter, c, str);
    }

    public static int  countRepitition(String str, char c) {
        int count = 0;
        for (char x: str.toCharArray()) {
            if (x == c) {
                count++;
            }
        }
        return count;
    }
}
