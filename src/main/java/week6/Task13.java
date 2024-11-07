package week6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Task13 {
    public static <T extends Number> HashMap<String, Integer> sumEvenAndOdd(List<T> numbers) {
        int sumOfEven = 0;
        int sumOfOdd = 0;

        for (T num : numbers) {
            int number = num.intValue();
            if (number % 2 == 0) {
                sumOfEven += number;
            } else {
                sumOfOdd += number;
            }
        }

        HashMap<String, Integer> result = new HashMap<>();
        result.put("Sum of even numbers", sumOfEven);
        result.put("Sum of odd numbers", sumOfOdd);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1);
        HashMap<String, Integer> result = sumEvenAndOdd(numbers);
        System.out.println("Even sum: " + result.get("Sum of even numbers"));
        System.out.println("Odd sum: " + result.get("Sum of odd numbers"));
    }
}
