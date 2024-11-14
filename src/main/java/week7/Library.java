package week7;

import java.util.*;

enum Status {
    AVAILABLE, CHECKED_OUT, RESERVED
}

class Book {
    private String title;
    private String author;
    private String isbn;
    private Status status;

    public Book(String title, String author, String isbn, Status status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\nStatus: " + status;
    }
}

class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Optional<Book> findBookByISBN(String ISBN) {
        return Optional.ofNullable(books.get(ISBN));
    }
}

class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class MainProgram {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Tvrdjava", "Mesa Selimovic", "ABC983", Status.AVAILABLE));
        library.addBook(new Book("Na Drini cuprija", "Ivo Andric", "MA0KCCC", Status.RESERVED));
        library.addBook(new Book("Proces", "Franz Kafka", "982KLM", Status.CHECKED_OUT));

        Scanner input = new Scanner(System.in);
        System.out.println("Enter ISBN: ");
        String ISBN = input.nextLine();

        Book book1 = library.findBookByISBN(ISBN)
                .orElse(new Book("Default Book", "Unknown", "000000000", Status.AVAILABLE));
        System.out.println("orElse:\n" + book1);

        Book book2 = library.findBookByISBN(ISBN)
                .orElseGet(() -> new Book("Lazy Default Book", "Lazy Author", "000000001", Status.RESERVED));
        System.out.println("orElseGet:\n" + book2);

        try {
            Book book3 = library.findBookByISBN(ISBN)
                    .orElseThrow(() -> new BookNotFoundException("Book with ISBN " + ISBN + " was not found!"));
            System.out.println("orElseThrow:\n" + book3);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Book book4 = library.findBookByISBN(ISBN)
                .orElseThrow(() -> new BookNotFoundException("Book not found!"));
        System.out.println("Successful lookup:\n" + book4);
    }

}


