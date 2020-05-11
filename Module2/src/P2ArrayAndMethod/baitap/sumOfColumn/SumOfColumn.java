package P2ArrayAndMethod.baitap.sumOfColumn;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfColumn {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] arrs = create2dArray();
        for (int[] arr: arrs ) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Input Comlumn you want to calculate: ");
        int col = Integer.parseInt(scan.nextLine());
        int sum = sumOfColumn(arrs, col);
        System.out.printf("The sum of column %d is: %d", col, sum);
    }
    public static int sumOfColumn(int[][] arr, int colId) {
        int sum = 0;
        for (int[] column: arr) {
            sum += column[colId];
        }
        return sum;
    }
    //Create 2d array
    public static int[][] create2dArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of rows: ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.print("Input number of columns: ");
        int col = Integer.parseInt(scanner.nextLine());
        int[][] arr2d = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr2d[i][j] = (int)Math.round(Math.random() * 100) + 1;
            }
        }
        return arr2d;
    }
}
