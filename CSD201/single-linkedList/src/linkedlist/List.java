package linkedlist;

public class List {

//Advantages:
//Easy to implement and flexible: The implementation of a singly linked list is relatively simple, and it offers flexibility in terms of adding, removing, and sorting elements.
//
//Easily extendable: Singly linked lists can be extended easily by adding new elements to the end of the list without the need to move or copy other elements.
//
//Flexible insertion and deletion: Elements can be inserted or deleted from any position in the list with constant time complexity O(1) (except when searching for the position).
//
//Memory efficient: Singly linked lists use linear memory space and do not require pre-allocation, which saves memory compared to fixed-size array data structures.
//
//Disadvantages:
//Slow random access: In a singly linked list, accessing a specific element requires traversing from the first element and moving through consecutive elements until reaching the desired element. This leads to increased time complexity for random access, which is O(n).
//
//Memory overhead: Each node in a singly linked list must store a reference to the next element, which consumes additional memory compared to storing data in an array, especially for small data elements.
//
//Not suitable for reverse traversal: Singly linked lists do not efficiently support reverse traversal (from the end to the beginning) without maintaining an additional pointer to the previous node. This makes reverse traversal inefficient and time-consuming.
//
//Potential for uncontrolled errors: Since singly linked lists use pointers, it's easy to encounter errors such as accessing invalid memory locations or losing track of pointers if not managed carefully.
    private Node head, tail;
    private int size;

    public List() {
        head = null;
        tail = null;
        size = 0;
    }

    // Thêm một phần tử vào đầu danh sách
    public void addFirst(String data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node newNode = new Node(data, head);
            head = newNode;
        }
        size++;
    }

    // Trả về phần tử đầu tiên trong danh sách
    public String getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    // Trả về phần tử cuối cùng trong danh sách
    public String getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }

    // Trả về số lượng phần tử trong danh sách
    public int size() {
        return size;
    }

    // Kiểm tra xem phần tử có tồn tại trong danh sách không
    public boolean contains(String data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Trả về chỉ mục của phần tử đầu tiên có giá trị cụ thể trong danh sách
    // Trả về -1 nếu không tìm thấy
    public int indexOf(String data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Loại bỏ phần tử đầu tiên khỏi danh sách
    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
    }

    // Loại bỏ phần tử cuối cùng khỏi danh sách
    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }

    // Loại bỏ phần tử tại chỉ mục cụ thể trong danh sách
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
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    // Trả về phần tử tại chỉ mục cụ thể trong danh sách
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

    // Thay đổi giá trị của phần tử tại chỉ mục cụ thể trong danh sách
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

    // Kiểm tra xem danh sách có rỗng không
    public boolean isEmpty() {
        return (head == null);
    }

    // Xóa toàn bộ phần tử trong danh sách
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // Phương thức bổ sung để thêm một Node vào cuối danh sách
    public void add(String data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node newNode = new Node(data, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

}
