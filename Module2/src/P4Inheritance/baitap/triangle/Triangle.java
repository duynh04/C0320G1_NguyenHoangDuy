package P4Inheritance.baitap.triangle;

import P4Inheritance.thuchanh.shape.Shape;
import P2ArrayAndMethod.baitap.triangleException.IlligalTriangleException;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        super();
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) throws IlligalTriangleException {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        checkAllSides(side1, side2, side3);
        isTriangle(side1, side2, side3);
    }

    public Triangle(double side1, double side2, double side3) throws IlligalTriangleException{
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        checkAllSides(side1, side2, side3);
        isTriangle(side1, side2, side3);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) throws IlligalTriangleException {
        checkSide(side1);
        this.side1 = side1;
        isTriangle(side1, side2, side3);
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) throws IlligalTriangleException {
        checkSide(side2);
        this.side2 = side2;
        isTriangle(side1, side2, side3);
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) throws IlligalTriangleException{
        checkSide(side3);
        this.side3 = side3;
        isTriangle(side1, side2, side3);
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
    private void checkSide(double side) throws IlligalTriangleException {
        if (side < 0)
            throw new IlligalTriangleException("Side must be greater than zero.");
    }
    private void checkAllSides(double s1, double s2, double s3) throws IlligalTriangleException {
        if(s1 < 0 || s2 < 0 || s3 < 0)
            throw new IlligalTriangleException("Sides must be greater than zero.");
    }
    private void isTriangle(double s1, double s2, double s3) throws IlligalTriangleException {
        if(s1 + s2 < s3 || s1 + s3 < s2 || s2 + s3 < s1)
            throw new IlligalTriangleException("This is not a triangle.");
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", Perimeter=" + getPerimeter() +
                ", Area=" + getArea() +
                ", color=" + super.getColor() +
                '}';
    }
}
