package week6;

public class Task3 {
    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        int indexOfSmallest = index;
        int minimum = array[index];
        for (int i = index; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;
    }

    public static void main(String[] args) {
        int[] values = {-1, 6, 9, 8, 12};
        System.out.println(indexOfTheSmallestStartingFrom(values, 1));
        System.out.println(indexOfTheSmallestStartingFrom(values, 2));
        System.out.println(indexOfTheSmallestStartingFrom(values, 4));
    }

}

