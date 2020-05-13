package P3ClassAndObject.baitap.stopwatch;

import java.util.Arrays;
import java.util.Date;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class StopWatch {
    private Date startTime;
    private Date endTime;
    public void start() {
        startTime = new Date();
    }
    public void stop() {
        endTime = new Date();
    }
    public float getElapsedTime() {
        return endTime.getTime() - startTime.getTime();
    }
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        double[] arr1 = new double[100000];
        // create arr 100000 random
        for (int i = 0; i < 100000; i++) {
           arr1[i] = floor(random() * 100) + 1;
        }
        System.out.println("Array before sort");
        System.out.println(Arrays.toString(arr1));
        sw.start();
        Sorting.SelectionSort(arr1);
        sw.stop();
        System.out.println("Array after sort");
        System.out.println(Arrays.toString(arr1));
        System.out.printf("Elapsed Time: %.2f ms.", sw.getElapsedTime());
    }
}
class Sorting {
    public static void SelectionSort(double[] arr) {
        final int _length = arr.length;
        int min;
        double temp;
        for (int i = 0; i < _length; i++) {
            min = i;
            for (int j = i + 1; j < _length; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] =  arr[i];
            arr[i] = temp;
        }
    }
}
