package week6;

public class Task2 {
    public static int indexOfSmallest(int[] array) {
        int index = 0;
        int minimum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] values = {6, 5, 8, 6, 11};
        System.out.println("Index of smallest: " + indexOfSmallest(values));
    }
}
