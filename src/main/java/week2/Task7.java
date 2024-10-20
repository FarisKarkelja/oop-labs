package week2;

public class Task7 {
    public static void main(String[] args) {
        drawStarsPyramid(5);
    }

    public static void drawStarsPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
