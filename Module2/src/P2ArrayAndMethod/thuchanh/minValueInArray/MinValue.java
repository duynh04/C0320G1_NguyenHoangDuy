package P2ArrayAndMethod.thuchanh.minValueInArray;

import java.util.Scanner;

public class MinValue {
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
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        // find min value in array
        int min  = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min  = array[j];
                index = j + 1;
            }
        }
        System.out.println("The smallest property value in the list is " + min + " ,at position " + index);
    }
}
