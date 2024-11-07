package week6;

public class Task1 {
    public static int smallest(int[] array) {
        int minimum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }
        return minimum;
    }

    public static void main(String[] args) {
        int[] values = {6, 5, 8, 6, 11};
        System.out.println("smallest: " + smallest(values));
    }
}
