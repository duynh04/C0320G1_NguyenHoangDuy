package P2ArrayAndMethod.baitap.SumDiagonal;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfDiagonal {
    public static void main(String[] args) {
        int[][] arr1 = create2dArray();
        for (int[] arr: arr1 ) {
            System.out.println(Arrays.toString(arr));
        }
        int sum = sumDiagonal(arr1);
        System.out.println("The sum of diagonal of matrix is " + sum);
    }
    // sum of diagonal
    public static int sumDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    //Create random squre matrix
    public static int[][] create2dArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input size of matrix: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[][] arr2d = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr2d[i][j] = (int)Math.round(Math.random() * 100) + 1;
            }
        }
        return arr2d;
    }
}
