package P1javalanguage.baitap.displayGreeting;

import java.util.Scanner;

public class Display {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Input your name: ");
    String name = scan.nextLine();
    System.out.printf("Hello %s", name);
  }
}
