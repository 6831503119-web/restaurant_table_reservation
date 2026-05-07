package main.datastructures;

public class CustomLinkedList<T> {

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private int size = 0;

    // Add element at the end
    public void add(T element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    // Get element at index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Remove element by object
    public boolean remove(T element) {
        if (head == null) {
            return false;
        }

        if (head.data.equals(element)) {
            head = head.next;
            size--;
            return true;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(element)) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get size
    public int size() {
        return size;
    }

    // Recursive traversal for display
    public void display() {
        displayRecursive(head);
        System.out.println();
    }

    private void displayRecursive(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        displayRecursive(node.next);
    }
}
