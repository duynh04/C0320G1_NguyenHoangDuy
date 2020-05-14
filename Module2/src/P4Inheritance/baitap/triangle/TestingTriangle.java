package P4Inheritance.baitap.triangle;

import P2ArrayAndMethod.baitap.triangleException.IlligalTriangleException;

public class TestingTriangle {
    public static void main(String[] args) {
            try {
                Triangle triangle = new Triangle(3, 4, 6);
                triangle.setSide3(10);
                System.out.println(triangle);

            } catch (IlligalTriangleException e ) {
                System.out.println(e.getMessage());
            }
    }
}
