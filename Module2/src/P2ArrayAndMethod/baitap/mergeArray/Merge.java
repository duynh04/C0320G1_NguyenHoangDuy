package P2ArrayAndMethod.baitap.mergeArray;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) {
        int[] arr1 = createArray();
        int[] arr2 = createArray();
        int[] merged = merge(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(merged));

    }
    //merge array
    public static int[] merge(int[] arr1, int[] arr2) {
        int size = arr1.length + arr2.length;
        int[] mergedArray = new int[size];
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        return mergedArray;
    }
    // create arry
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
