package P2ArrayAndMethod.baitap.insertArray;

import java.util.Arrays;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = createArray();
        System.out.println(Arrays.toString(arr));
        System.out.print("Value to insert: ");
        int val = Integer.parseInt(scanner.nextLine());
        System.out.print("Insert value at position: ");
        int id = Integer.parseInt(scanner.nextLine());
        insertValue(arr, val, id);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertValue(int[] array, int newValue, int index) {
        int length = array.length;
        int id = index - 1;
        for (int i = length - 1; i > id; i--) {
            array[i] = array[i - 1];
        }
        array[id] = newValue;
    }
    public static int[] createArray() {
        int num;
        int element;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input size of array: ");
        num = Integer.parseInt(scanner.nextLine());
        array = new int[num] ;
        for (int j = 0; j < num; j++) {
            System.out.printf("Element %d : ", j + 1);
            element = Integer.parseInt(scanner.nextLine());
            array[j] = element;
        }
        return array;
    }
}
