package week1;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        num = Integer.parseInt(input.nextLine());
        if(num > 0)
            System.out.println("The number is positive.");
        else {
            System.out.println("The number is not positive.");
        }

    }
}
