package P2ArrayAndMethod.baitap.deleteArray;

import java.util.Arrays;
import java.util.Scanner;

public class Del {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = createArray();
        System.out.println(Arrays.toString(arr1));
        System.out.print("Value you want to delete: ");
        int val = Integer.parseInt(scanner.nextLine());
        arr1 = deleteElement(arr1, val);
        System.out.println(Arrays.toString(arr1));
    }
    // delete value
    public static int[] deleteElement(int[] arr, int delValue) {
        int size = arr.length;
        int[] tempArray = new int[size];
        int count = 0 ;
        for (int val : arr) {
            if (val != delValue) {
                tempArray[count] = val;
                count++;
            }
        }
        return  tempArray;
    }
    // create an array
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
