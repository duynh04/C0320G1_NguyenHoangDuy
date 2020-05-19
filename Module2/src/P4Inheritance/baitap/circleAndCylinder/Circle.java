package P4Inheritance.baitap.circleAndCylinder;

public class Circle {
    private double radius;
    public Circle () {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getCircumference() {
        return  2 * Math.PI * radius;
    }
    void testing() {

    }
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", area=" + getArea() +
                ", circumference=" + getCircumference() +
                '}';
    }
}
