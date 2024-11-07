//Task 12

package week6;

import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statement\n" +
                "\tquit - quit the text user interface\n" +
                "\ttranslate - asks a word and prints its translation\n" +
                "\tadd - adds a word pair to the dictionary\n");
        while (true) {
            System.out.println("Statement: ");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("Cheers");
                break;
            } else if (command.equals("add")) {
                add();
            } else if (command.equals("translate")) {
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }

    public void add() {
        System.out.print("In Finnish: ");
        String word = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();
        dictionary.add(word, translation);
        System.out.println("Word pair added");
    }

    public void translate() {
        System.out.print("Give a word: ");
        String word = reader.nextLine();
        String translation = dictionary.translate(word);
        System.out.println("Translation: " + translation);
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        Scanner reader = new Scanner(System.in);

        TextUserInterface ui = new TextUserInterface(reader, dictionary);

        ui.start();
    }

}
