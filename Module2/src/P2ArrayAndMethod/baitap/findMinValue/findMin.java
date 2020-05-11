package P2ArrayAndMethod.baitap.findMinValue;

import java.util.Arrays;
import java.util.Scanner;

public class findMin {
    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.printf("The min value in array is: %d", arr[0]);
    }
    //create array
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
