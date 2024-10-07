package week2;

public class Task8 {
    public static void main(String[] args) {
        printInvertedPyramid(10);
    }

    public static void printInvertedPyramid(int rows) {
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
