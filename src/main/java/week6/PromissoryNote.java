//Task 9 and 10

package week6;

import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> loans;

    public PromissoryNote() {
        loans = new HashMap<>();
    }

    public void setLoan(String toWhom, double value) {
        loans.put(toWhom, value);
    }

    public double howMuchIsTheDebt(String whose) {
        return loans.getOrDefault(whose, 0.0);
    }

    public static void main(String[] args) {
        HashMap<String, String> object = new HashMap<String, String>();

        object.put("matti", "mage");
        object.put("mikael", "mixu");
        object.put("arto", "arppa");

        System.out.println(object.get("mikael"));

        PromissoryNote mattisNote = new PromissoryNote();

        mattisNote.setLoan("Arto", 51.5);
        mattisNote.setLoan("Mikael", 30);

        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
        System.out.println(mattisNote.howMuchIsTheDebt("Joel"));

        mattisNote.setLoan("Arto", 51.5);
        mattisNote.setLoan("Arto", 10.5);

        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
    }
}
