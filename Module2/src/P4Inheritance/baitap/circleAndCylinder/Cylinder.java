package P4Inheritance.baitap.circleAndCylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder() {
        super();
        height = 1.0;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double height) {
        super();
        this.height = height;
    }
    public double getVolume() {
        return  super.getArea() * height;
    }
    public double getBaseArea() {
        return super.getArea();
    }
    public double getSideArea() {
        return super.getCircumference() * height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", radius=" + super.getRadius() +
                ", base area=" + getBaseArea() +
                ", side area=" + getSideArea() +
                ", volume=" + getVolume() +
                '}';
    }
}
