package week2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        numbersBetween();
    }

    public static void numbersBetween() {

        Scanner input = new Scanner(System.in);
        int firstNumber, lastNumber;
        System.out.println("Enter first number: ");
        firstNumber = Integer.parseInt(input.nextLine());
        System.out.println("Enter last number: ");
        lastNumber = Integer.parseInt(input.nextLine());

        if (firstNumber < lastNumber) {
            firstNumber++;
            while (firstNumber < lastNumber) {
                System.out.println(firstNumber);
                firstNumber++;
            }
        } else if (firstNumber > lastNumber) {
            firstNumber--;
            while (firstNumber > lastNumber) {
                System.out.println(firstNumber);
                firstNumber--;
            }
        } else {
            System.out.println("The numbers are equal.");
        }

    }
}



