package P1javalanguage.baitap.exchangeCurrency;

import java.util.Scanner;

public class Exchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input USD: ");
        float usd = scanner.nextFloat();
        float vnd = usd * 23000;
        System.out.printf("%.2f USD = %.2f VND", usd, vnd);
    }
}
