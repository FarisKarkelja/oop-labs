package week2;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        printText();
    }

    public static void printText() {
        String text = "In the beginning there were the swamp, the hoe and Java.";
        int numOfPrints;
        Scanner input = new Scanner(System.in);
        System.out.println("How many times should the text be printed?");
        numOfPrints = Integer.parseInt(input.nextLine());
        for (int i = 0; i < numOfPrints; i++) {
            System.out.println(text);
        }
    }
}
