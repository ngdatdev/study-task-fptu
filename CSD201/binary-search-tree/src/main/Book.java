
package main;


public class Book {
    String isbn;
    String title;
    String author;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    
    public int getIsbnInt() {
        String isbnInt = isbn.substring(4);
        return Integer.parseInt(isbnInt);
    }

}
