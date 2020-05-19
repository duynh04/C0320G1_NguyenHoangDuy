package P4Inheritance.thuchanh.shape;

import P5InterfaceAndAbstract.baitap.resize.Resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius;
    public Circle() {
        super();
        radius = 1.0;
    }
    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "A Circle with radius = " + radius + ", which subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        setRadius(radius * percent / 100);
    }
}
