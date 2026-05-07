package main.datastructures;

public class CustomQueue<T> {

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front = null; // First element
    private Node rear = null; // Last element
    private int size = 0;

    // Add element to queue (enqueue)
    public void add(T element) {
        Node newNode = new Node(element);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove and return front element (dequeue)
    public T poll() {
        if (front == null) {
            return null;
        }

        T data = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    // Peek front element without removing
    public T peek() {
        if (front == null) {
            return null;
        }
        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get size
    public int size() {
        return size;
    }

    // Get element at index without removing (for display purposes)
    public T getAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node temp = front;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp != null ? temp.data : null;
    }

    // Display queue
    public void display() {
        Node temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
