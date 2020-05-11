package P2ArrayAndMethod.thuchanh.errorHandling;

import java.util.Random;
import java.util.Scanner;

public class ArrayException {
    public ArrayException(int x) {

    }
    public static void main(String[] args) {
//        var a = 8;
//        ArrayException();
        ArrayException  a = new ArrayException();
        ArrayExample arrExample = new ArrayExample();

        int[] arr = arrExample.createRandom();

        Scanner scaner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
        int x = scaner.nextInt();
        try {
            System.out.println("Giá trị của phần tử có chỉ số " + x + " là " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Chỉ số vượt quá giới hạn của mảng");
        }
    }
}
class ArrayExample {
    public int[] createRandom() {
            Random rd = new Random();
            int[] arr = new int[100];
            System.out.println("Danh sách phần tử của mảng: " );
            for (int i = 0; i < 100; i++) {
                arr[i] = rd.nextInt(100);
                System.out.print(arr[i]+ " ");
            }
            return arr;
        }
    }
