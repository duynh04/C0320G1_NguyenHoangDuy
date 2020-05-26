package P5InterfaceAndAbstract.baitap.colorable;

import P4Inheritance.thuchanh.shape.*;

public class Testing {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Square();
        shapes[2] = new Rectangle();
        for (Shape shape: shapes) {
            if(shape instanceof Square) {
                Colorable squareColor = (Square)shape;
                squareColor.howToColor();
            }
        }
    }
}
