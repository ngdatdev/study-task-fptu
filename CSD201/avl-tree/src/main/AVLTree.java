package main;


public class AVLTree {

    Node root;

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    Node rightRotate(Node a) { // element
        Node b = a.left;// element. 
        Node c = b.right;
        b.right = a;
        a.left = c;
        a.height = Math.max(height(a.right), height(a.left)) + 1;
        b.height = Math.max(height(b.right), height(b.left)) + 1;
        return b;
    }

    Node leftRotete(Node a) {
        Node b = a.right;
        Node c = b.left;
        b.left = a;
        a.right = c;
        a.height = Math.max(height(a.right), height(a.left)) + 1; 
        b.height = Math.max(height(b.right), height(b.left)) + 1; 
        return b;
    }

    void insertContact(Contact contact) {
        root = insert(root, contact);
    }

    Node insert(Node node, Contact contact) {
        if (node == null) {
            return new Node(contact);
        }

        if (contact.name.compareTo(node.contact.name) < 0) {
            node.left = insert(node.left, contact);
        }
        if (contact.name.compareTo(node.contact.name) > 0) {
            node.right = insert(node.right, contact);
        } else {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalanceFactor(node);

        if (balance > 1 && contact.name.compareTo(node.left.contact.name) < 0) {
            return rightRotate(node);
        } 

        if (balance < -1 && contact.name.compareTo(node.right.contact.name) > 0) {
            return leftRotete(node);
        }

        if (balance > 1 && contact.name.compareTo(node.left.contact.name) > 0) {
            node.left = leftRotete(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && contact.name.compareTo(node.right.contact.name) < 0) {
            node.right = rightRotate(node.right);
            return leftRotete(node);
        }

        return node;
    }

    int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    void inOrder() {
        inOrderRecursion(root);
    }

    void inOrderRecursion(Node node) {
        if (node != null) {
            inOrderRecursion(node.left);
            System.out.println(node.contact);
            inOrderRecursion(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree contactsTree = new AVLTree();

        Contact alice = new Contact("1.Alice Johnson", "555-0101", "alice.johnson@email.com");
        Contact bob = new Contact("2.Bob Smith", "555-0102", "bob.smith@email.com");
        Contact charlie = new Contact("3.Charlie Davis", "555-0103", "charlie.davis@email.com");
        Contact diana = new Contact("4.Diana Hayes", "555-0104", "diana.hayes@email.com");
        Contact ethan = new Contact("5.Ethan Moore", "555-0105", "ethan.moore@email.com");
        Contact fiona = new Contact("6.Fiona Campbell", "555-0106", "fiona.campbell@email.com");
        Contact george = new Contact("7. George Wright", "555-0107", "george.wright@email.com");

        contactsTree.insertContact(alice);
        contactsTree.insertContact(bob);
        contactsTree.insertContact(diana);
        contactsTree.insertContact(ethan);
        contactsTree.insertContact(fiona);
        contactsTree.insertContact(george);
        contactsTree.insertContact(charlie);

        contactsTree.inOrder();
    }

}
