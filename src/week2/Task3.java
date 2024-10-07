package week2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        ifZero();
    }

    public static void ifZero() {
        Scanner input = new Scanner(System.in);
        int number;
        int sum = 0;
        while (true) {
            System.out.println("Enter a number: ");
            number = Integer.parseInt(input.nextLine());
            sum += number;
            System.out.println("Sum is: " + sum);
            if (number == 0) {
                break;
            }
        }
        input.close();

    }
}
