//Task8

package week6;

public class Book {
    private String title;
    private String publisher;
    private int year;

    public Book(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public String title(){
        return title;
    }

    public String publisher(){
        return publisher;
    }

    public int year(){
        return year;
    }

    public String toString(){
        return title + " " + publisher + " " + year;
    }

    public static void main(String[] args){
        Book cheese = new Book("Cheese Problems Solved", "Woodhead Publishing", 2007);
        System.out.println(cheese.title());
        System.out.println(cheese.publisher());
        System.out.println(cheese.year());
        System.out.println(cheese);
    }
}

