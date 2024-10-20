package week2;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        sumOfTwoToThePowerOfN();
    }

    public static void sumOfTwoToThePowerOfN() {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Please enter a number: ");
        n = Integer.parseInt(input.nextLine());
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += (int) Math.pow(2, i);
        }
        System.out.println("Sum is: " + sum);

    }
}
