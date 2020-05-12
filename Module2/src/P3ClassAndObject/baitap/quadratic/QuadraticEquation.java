package P3ClassAndObject.baitap.quadratic;

import P3ClassAndObject.thuchanh.rectangle.Rectangle;

import java.util.Scanner;

public class QuadraticEquation {
    private double a = 0;
    private double b = 0;
    private double c = 0;
    private double delta = 0;
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        delta = b * b - 4 * a * c;
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public void setA(double val) {
        a = val;
    }
    public void setB(double val) {
        b = val;
    }
    public void setC(double val) {
        c = val;
    }
    public double getDiscriminant() {
        return delta;
    }
    public double getRoot1() {
        return (-b + Math.sqrt(delta)) / 2 / a;
    }
    public double getRoot2() {
        return (-b - Math.sqrt(delta)) / 2 / a;
    }
    public static void main(String[] args) {
        double x1, x2;
        Scanner input = new Scanner(System.in);
        System.out.print("Input a: ");
        double a = input.nextDouble();
        if(a < 0) {
            System.out.println("a > 0");
            return;
        }
        System.out.print("Input b: ");
        double b = input.nextDouble();
        System.out.print("Input c: ");
        double c = input.nextDouble();
        QuadraticEquation e1 = new QuadraticEquation(a, b, c);
        double delta = e1.getDiscriminant();
        if (delta >= 0) {
            x1 = e1.getRoot1();
            x2 = e1.getRoot2();
            System.out.printf("x1 = %.2f, x2 = %.2f", x1, x2);
        } else {
            System.out.println("Cannot solve");
        }
    }
}
