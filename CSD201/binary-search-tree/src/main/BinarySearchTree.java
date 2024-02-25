package main;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insertBook(Book book) {
        if (root == null) {
            root = new Node(book);
            return;
        }

        Node p = root, f = null;
        while (p != null) {
            if (p.book.isbn.equals(book.isbn)) {
                System.out.println("Already exist");
                return;
            }
            f = p;
            if (p.book.getIsbnInt() > book.getIsbnInt()) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (f.book.getIsbnInt() > book.getIsbnInt()) {
            f.left = new Node(book);
        } else {
            f.right = new Node(book);
        }

    }

    public Node search(String isbn) {
        return searchRecursion(root, isbn);
    }

    public Node searchRecursion(Node current, String isbn) {
        if (current == null || current.book.isbn.equals(isbn)) {
            return current;
        }

        if (current.book.isbn.compareTo(isbn) > 0) {
            return searchRecursion(current.left, isbn);
        } else {
            return searchRecursion(current.right, isbn);
        }
    }
    
    void inorder() {
        inorderRecursive(root);
    }

    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println("ISBN: " + root.book.isbn + ", Title: " + root.book.title + ", Author: " + root.book.author);
            inorderRecursive(root.right);
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertBook(new Book("978-0143127796", "The Martian", "Andy Weir"));
        bst.insertBook(new Book("978-0316036733", "The Hunger Games", "Suzanne Collins"));
        bst.insertBook(new Book("978-0439023528", "Catching Fire", "Suzanne Collins"));
        bst.insertBook(new Book("978-0545010221", "Harry Potter and the Deathly Hallows", "J.K. Rowling"));
        
        System.out.println(bst.search("978-0316036733").book.title);
        
    }

}
