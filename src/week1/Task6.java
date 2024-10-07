package week1;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        int firstNumber, secondNumber;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number: ");
        firstNumber = Integer.parseInt(input.nextLine());
        System.out.println("Enter second number: ");
        secondNumber = Integer.parseInt(input.nextLine());
        if (firstNumber > secondNumber) {
            System.out.println("First number is greater than the second number.");
        } else if (firstNumber < secondNumber) {
            System.out.println("Second number is greater than the first number.");
        } else {
            System.out.println("Provided numbers are equal.");
        }
    }
}
