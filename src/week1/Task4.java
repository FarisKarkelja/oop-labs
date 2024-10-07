package week1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int firstNumber, secondNumber;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        firstNumber = Integer.parseInt(input.nextLine());
        System.out.print("Enter second number: ");
        secondNumber = Integer.parseInt(input.nextLine());
        int sumOfTwoNumbers = firstNumber + secondNumber;
        System.out.println("Sum of provided numbers is: " + sumOfTwoNumbers);
    }
}
