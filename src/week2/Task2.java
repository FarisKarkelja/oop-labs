package week2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        sumOfNumbers();
    }

    public static void sumOfNumbers() {
        Scanner input = new Scanner(System.in);
        int num1, num2, num3;

        System.out.println("Enter 1st number: ");
        num1 = Integer.parseInt(input.nextLine());
        System.out.println("Enter 2nd number: ");
        num2 = Integer.parseInt(input.nextLine());
        System.out.println("Enter 3rd number: ");
        num3 = Integer.parseInt(input.nextLine());

        int sum = num1 + num2 + num3;
        System.out.println("Sum is: " + sum);
    }
}
