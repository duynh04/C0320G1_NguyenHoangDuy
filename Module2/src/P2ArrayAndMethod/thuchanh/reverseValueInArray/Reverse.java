package P2ArrayAndMethod.thuchanh.reverseValueInArray;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        // input size of array
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        // create value for array element
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        // display array
        System.out.print("Property list: ");
        for (int value : array) {
            System.out.print(value + "\t");
        }
        System.out.print("Property list: ");
        for (int value : array) {
            System.out.print(value + "\t");
        }
        //reverse value in array
        int temp;
        for (int j = 0; j <= size / 2; j++) {
           temp = array[j];
           array[j] = array[size - 1 - j];
           array[size - 1 - j] = temp;
        }
        System.out.print("\nReverse array: ");
        for (int a: array) {
            System.out.print(a + "\t");
        }
    }
}
