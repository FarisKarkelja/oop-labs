//Task8

package week6;

public class StringUtils {

    public static boolean included(String word, String searched) {
        if (word == null || searched == null) {
            return false;
        }

        String trimmed = searched.trim().toUpperCase();
        String toUpper = word.toUpperCase();

        return toUpper.contains(trimmed);
    }

    public static void main(String[] args) {
        Library Library = new Library();

        Library.addBook(new Book("Cheese Problems Solved", "Woodhead Publishing", 2007));
        Library.addBook(new Book("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        Library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));

        for (Book book : Library.searchByTitle("CHEESE")) {
            System.out.println(book);
        }

        System.out.println("---");
        for (Book book : Library.searchByPublisher("PENGUIN  ")) {
            System.out.println(book);
        }

    }
}
