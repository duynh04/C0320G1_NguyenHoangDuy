package P4Inheritance.thuchanh.shape;

public class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this.filled = true;
        this.color = "green";
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A shape with a color of " + color + " and " + (filled ? "filled" : "not filled");
    }
}
