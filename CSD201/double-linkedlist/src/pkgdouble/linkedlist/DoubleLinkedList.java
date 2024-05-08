/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgdouble.linkedlist;

/**
 *
 * @author admin
 */
public class DoubleLinkedList {
    
//Advantages:
//Bidirectional traversal: Unlike singly linked lists, doubly linked lists allow bidirectional traversal. This means you can traverse the list both forwards and backwards efficiently, as each node contains references to both the next and previous nodes.
//
//Efficient deletion and insertion: Doubly linked lists support efficient insertion and deletion operations at any position in the list. This is because each node stores references to both the next and previous nodes, allowing for constant time complexity (O(1)) for these operations, given a reference to the node.
//
//More flexibility: Doubly linked lists offer more flexibility compared to singly linked lists due to bidirectional traversal and efficient insertion and deletion operations. This makes them suitable for scenarios where frequent modification of the list structure is required.
//
//Easier implementation of certain algorithms: Some algorithms, such as reversing a list or implementing certain types of iterators, are easier to implement with doubly linked lists compared to singly linked lists.
//
//Disadvantages:
//Higher memory overhead: Doubly linked lists require each node to store references to both the next and previous nodes, leading to higher memory overhead compared to singly linked lists, especially for large datasets.
//
//Complexity of implementation: The implementation of a doubly linked list is more complex than that of a singly linked list due to the additional references to previous nodes. Managing these references correctly requires careful attention to detail to avoid errors such as memory leaks or pointer corruption.
//
//Potential for inconsistency: Since doubly linked lists maintain references to both the next and previous nodes, ensuring the consistency of these references during insertion, deletion, and other operations is crucial. Failing to maintain consistency can lead to errors such as broken links or data corruption.
//
//Less memory-efficient than arrays: While doubly linked lists offer flexibility and efficient insertion and deletion operations, they are generally less memory-efficient than arrays, especially for small datasets, due to the additional overhead of storing references to previous nodes.

    private Node head, tail;
    private int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Kiểm tra xem danh sách có rỗng không
    public boolean isEmpty() {
        return size == 0;
    }

    // Trả về kích thước của danh sách
    public int size() {
        return size;
    }

    // Thêm một phần tử vào đầu danh sách
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Thêm một phần tử vào cuối danh sách
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Xóa phần tử đầu tiên trong danh sách
    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // Xóa phần tử cuối cùng trong danh sách
    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // Hiển thị danh sách từ đầu đến cuối
    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Hiển thị danh sách từ cuối đến đầu
    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Thêm một phần tử vào vị trí cụ thể trong danh sách
    public void add(int index, String data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.prev = current;
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    // Xóa phần tử tại vị trí cụ thể trong danh sách
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    // Truy cập phần tử tại vị trí cụ thể trong danh sách
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Cập nhật phần tử tại vị trí cụ thể trong danh sách
    public void set(int index, String data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    // Lớp nội tuyến Node
    private class Node {
        String data;
        Node prev, next;

        public Node(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

}
