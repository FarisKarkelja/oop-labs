package week2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        passwordManager();
    }

    public static void passwordManager() {
        Scanner input = new Scanner(System.in);
        String password;
        String targetPassword = "carrot";

        while (true) {
            System.out.println("Enter password");
            password = input.nextLine();
            if (password.equals(targetPassword)) {
                System.out.println("Right!!!     Secret is 'dnfjdfkng snfkrkj'");
                break;
            }
        }
        input.close();
    }
}