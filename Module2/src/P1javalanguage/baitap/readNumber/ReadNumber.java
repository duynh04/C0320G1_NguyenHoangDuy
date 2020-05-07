package P1javalanguage.baitap.readNumber;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input your weight: ");
        int weight = scan.nextInt();
        String result = transfer(weight);
        System.out.println(result);
    }
    public static String transfer(int num) {
        String[] strNumber = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] specialNumber = {"", "", "twen", "thir", "for", "fif"};
        int[] sepNums = new int[3]; // 0: don vi, 1: chuc, 2:tram
        int count = 0; // number of number in a number
        int mod;
        int remain = num;
        String result = "";
        do {
           mod = remain % 10;
           sepNums[count] = mod;
           remain = remain / 10;
           count++;
        } while (remain != 0);
        switch (count) {
            case 3:
                result += strNumber[sepNums[2]] + " hundred and ";
            case 2:
                if(sepNums[1] == 1) {
                    if (sepNums[0] == 0) {
                        result = "ten";
                    } else if (sepNums[0] == 1) {
                        result += "eleven";
                    } else if (sepNums[0] == 2) {
                        result += "twelve";
                    } else if (sepNums[0] < 6) {
                        result += specialNumber[sepNums[0]] + "teen ";
                    } else {
                        result += strNumber[sepNums[0]] + "teen ";
                    }
                    break;
                } else if (sepNums[1] < 6) {
                   result += specialNumber[sepNums[1]] + "ty ";
                } else {
                    result += strNumber[sepNums[1]] + "ty ";
                }
            case 1:
                result += strNumber[sepNums[0]];
        }
        return result;
    }
}
