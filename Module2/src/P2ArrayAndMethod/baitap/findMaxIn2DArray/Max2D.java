package P2ArrayAndMethod.baitap.findMaxIn2DArray;

import java.util.Arrays;
import java.util.Scanner;

public class Max2D {
    public static void main(String[] args) {
        int[][] arrs = create2dArray();
        for (int[] arr : arrs) {
            System.out.println(Arrays.toString(arr));
        }
        findMax(arrs);
    }
    //find max value

    public static void findMax(int[][] arrs) {
        int row = 0, col = 0;
        int maxRow = arrs[0][0];
        int maxCol;
        for (int i = 0; i < arrs.length; i++) {
            maxCol = arrs[i][0];
            for (int j = 1; j < arrs[i].length; j++) {
                if (arrs[i][j] > maxCol) {
                    maxCol = arrs[i][j];
                    col = j;
                }
            }
            if (maxCol > maxRow) {
                maxRow = maxCol;
                row = i;
            }
        }
        System.out.printf("The max value is %d at position (%d, %d)", maxRow, row + 1, col + 1);
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
