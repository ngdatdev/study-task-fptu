
package circle.linkedlist;

public class CircularLinkedList {
//Advantages:
//
//Circularity: The primary advantage of a circular linked list is that it forms a closed loop. This means there is no "end" to the list, and traversal can be done indefinitely without reaching a null pointer. This property is useful in applications where continuous cycling through the elements is required, such as in scheduling algorithms.
//
//Efficient Operations: Certain operations, such as insertion and deletion at the beginning or end of the list, can be more efficient in a circular linked list compared to a linear one. This is because no traversal to the end of the list is necessary, and operations can be performed directly on the head or tail pointers.
//
//Space Efficiency: Circular linked lists can be more space-efficient than linear linked lists in certain scenarios. For example, in applications where the last element needs to be connected to the first element, a circular linked list eliminates the need for an additional pointer to maintain this connection.
//
//Disadvantages:
//
//Complexity: Circular linked lists can be more complex to implement and manage compared to linear linked lists. Handling circular references requires careful attention to avoid infinite loops or incorrect behavior during traversal, insertion, or deletion.
//
//Traversal Challenges: Traversing a circular linked list requires additional logic to determine when to stop, as there is no natural end point. If not implemented carefully, this can lead to infinite loops or incorrect results.
//
//Memory Management: Circular linked lists can complicate memory management, especially in languages without automatic garbage collection. If nodes are not properly deallocated when no longer needed, memory leaks can occur more easily in a circular structure compared to a linear one.
//
//Difficulty in Reversal: Reversing a circular linked list is more complicated than reversing a linear linked list. In a linear linked list, reversing involves changing the direction of pointers sequentially, while in a circular linked list, additional steps are required to maintain the circularity of the list.
    private Node head;
    private int size;

    public CircularLinkedList() {
        head = null;
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
            newNode.next = newNode; // Cho newNode trỏ vào chính nó
            head = newNode;
        } else {
            newNode.next = head;
            Node lastNode = getLastNode();
            lastNode.next = newNode;
            head = newNode;
        }
        size++;
    }

    // Thêm một phần tử vào cuối danh sách
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            newNode.next = newNode; // Cho newNode trỏ vào chính nó
            head = newNode;
        } else {
            Node lastNode = getLastNode();
            newNode.next = head;
            lastNode.next = newNode;
        }
        size++;
    }

    // Xóa phần tử đầu tiên trong danh sách
    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            head = null;
        } else {
            Node lastNode = getLastNode();
            lastNode.next = head.next;
            head = head.next;
        }
        size--;
    }

    // Xóa phần tử cuối cùng trong danh sách
    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            head = null;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = head.next;
        }
        size--;
    }

    // Hiển thị danh sách từ đầu đến cuối
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Trả về nút cuối cùng trong danh sách
    private Node getLastNode() {
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        return current;
    }

    // Lấy phần tử tại chỉ mục cụ thể
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

    // Xóa phần tử tại chỉ mục cụ thể
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        size--;
    }

    // Thêm một phần tử tại chỉ mục cụ thể
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
        Node prev = null;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = newNode;
        newNode.next = current;
        size++;
    }

    // Lớp nội tuyến Node
    private static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
}