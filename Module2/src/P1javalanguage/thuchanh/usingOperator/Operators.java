package P1javalanguage.thuchanh.usingOperator;
import java.util.Scanner;
public class Operators {
    public static void main(String[] args) {
        float w,h;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input width");
        w = scan.nextFloat();
        System.out.println("Input height");
        h = scan.nextFloat();
        System.out.println(area(w, h));
    }
    public static float area(float w, float h) {
        return w * h;
    }
}
