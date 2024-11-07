//Task5

package week6;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static boolean search(int[] array, int searchedValue) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (array[m] == searchedValue) {
                return true;
            }
            if (array[m] < searchedValue) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {-3, 2, 3, 4, 7, 8, 12};
        Scanner reader = new Scanner(System.in);
        System.out.println("Values of the array: " + Arrays.toString(array));
        System.out.println();
        System.out.println("Enter searched number: ");
        String searchedValue = reader.nextLine();
        boolean result = BinarySearch.search(array, Integer.parseInt(searchedValue));
        if (result) {
            System.out.println("Value " + searchedValue + " is in the array");
        } else {
            System.out.println("Value " + searchedValue + " is not in the array");
        }
    }
}
