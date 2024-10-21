package week4.Task2;

enum FillType {
    FILLED, NOT_FILLED
}

public class Shape {
    private String color;
    private FillType fillType;

    public Shape(String color, FillType fillType) {
        this.color = color;
        this.fillType = fillType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public FillType getFillType() {
        return fillType;
    }

    public void setFillType(FillType fillType) {
        this.fillType = fillType;
    }

    public String displayInfo() {
        return "Color is " + this.color + " and it is " + this.fillType + ".";
    }

    public double getArea(){
        return 0;
    }
}
