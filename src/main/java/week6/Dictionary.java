//Task 11

package week6;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> translations;

    public Dictionary() {
        translations = new HashMap<>();
    }

    public String translate(String word) {
        return translations.getOrDefault(word, "Word " + word + " is not in dictionary");
    }

    public void add(String word, String translation) {
        translations.put(word, translation);
    }

    public int amountOfWords() {
        return translations.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> list = new ArrayList<>();
        for (String key : translations.keySet()) {
            list.add(key + " = " + translations.get(key));
        }
        return list;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");

        System.out.println(dictionary.amountOfWords());

        dictionary.add("cembalo", "harpsichord");

        System.out.println(dictionary.amountOfWords());

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("porkkana"));

        ArrayList<String> translations = dictionary.translationList();
        for (String translation : translations) {
            System.out.println(translation);
        }


    }
}
