package P5InterfaceAndAbstract.baitap.colorable;

import P4Inheritance.thuchanh.shape.*;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Testing {

    public static void main(String[] args) {
//        Shape[] shapes = new Shape[3];
//        shapes[0] = new Circle();
//        shapes[1] = new Square();
//        shapes[2] = new Rectangle();
//        for (Shape shape: shapes) {
//            if(shape instanceof Square) {
//                Colorable squareColor = (Square)shape;
//                squareColor.howToColor();
//            }
//        }
        String a = "123";
        String b = "123";
        String c = new String("123");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.put(4, 5);
//        map.put(2, 6);
//        map.put(null, 7);
//        for (Map.Entry<Integer, Integer> u: map.entrySet() ) {
//            System.out.println(u.getKey() + ":  " + u.getValue());
//        }
    }
}
