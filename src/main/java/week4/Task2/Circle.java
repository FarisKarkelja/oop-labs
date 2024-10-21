package week4.Task2;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, FillType fillType, double radius) {
        super(color, fillType);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String displayInfo() {
        return "Color is " + super.getColor() + ", it is " + super.getFillType() + " and it has a radius of " + this.radius + " cm.";
    }

    @Override
    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    public double calculateCircumference(double PI, double r) {
        return 2 * PI * r;
    }

    public double calculateCircumference(double r) {
        final double pi = 3.14;
        return 2 * pi * r;
    }
}
