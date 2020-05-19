package P5InterfaceAndAbstract.baitap.resize;

import P4Inheritance.thuchanh.shape.*;

public class TestSuite {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(2, 5);
        shapes[2] = new Circle(20);
        System.out.println("Before resize: ");
        for (Shape shape: shapes ) {
            System.out.println(shape);
        }
        for (Shape shape: shapes) {
            if(shape instanceof Circle) {
                Circle c1 = (Circle)shape;
                c1.resize(50);
            } else if(shape instanceof Rectangle) {
                Rectangle r1 = (Rectangle)shape;
                r1.resize(50);
            } else {
                Square s1 = (Square)shape;
                s1.resize(50);
            }
        }
        System.out.println("After resize: ");
        for (Shape shape: shapes ) {
            System.out.println(shape);
        }
    }
}
