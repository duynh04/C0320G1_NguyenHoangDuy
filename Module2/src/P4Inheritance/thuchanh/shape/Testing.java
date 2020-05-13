package P4Inheritance.thuchanh.shape;

public class Testing {
    public static void main(String[] args) {
        // Test for Circle
//        Circle Circle = new Circle();
//        System.out.println(Circle);
//
//        Circle = new Circle(3.5);
//        System.out.println(Circle);
//
//        Circle = new Circle("indigo", false, 3.5);
//        System.out.println(Circle);

        // Test for Rectangle
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle("orange", true,2.5 , 3.8);
        System.out.println(rectangle);
    }
}
