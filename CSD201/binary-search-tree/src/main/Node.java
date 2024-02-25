
package main;


public class Node {
    Book book;
    Node left, right;
    
    public Node(Book book) {
        this.book = book;
        left = right = null;
    }
    
}
