package week4.Task2;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape("red", FillType.FILLED);
        Circle circle = new Circle("yellow", FillType.NOT_FILLED, 14.56);
        Rectangle rectangle = new Rectangle("blue", FillType.FILLED, 14.3, 9.7);

        System.out.println(shape.displayInfo());
        System.out.println(circle.displayInfo());
        System.out.println(rectangle.displayInfo());

        double result0 = shape.getArea();
        System.out.println(result0);

        double result1 = circle.getArea();
        System.out.println(result1);

        double result2 = circle.calculateCircumference(3.14, 15.48);
        System.out.println(result2);

        double result3 = circle.calculateCircumference(9.27);
        System.out.println(result3);

        double result4 = rectangle.getArea();
        System.out.println(result4);
    }
}
