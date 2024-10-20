package week2;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        guessingGame();
    }

    public static void guessingGame() {
        Scanner input = new Scanner(System.in);
        int guess;
        int counter = 0;
        int targetNumber = 31;
        while (true) {
            System.out.println("Guess the number: ");
            guess = Integer.parseInt(input.nextLine());
            counter++;
            if (guess > targetNumber) {
                System.out.println("Lower!  -  This is your " + counter + ". guess !");
            } else if (guess < targetNumber) {
                System.out.println("Higher!  -  This is your " + counter + ". guess !");
            } else {
                System.out.println("You are correct!");
                System.out.print("You made " + counter + " guesses !");
                break;
            }
        }
        input.close();
    }
}
