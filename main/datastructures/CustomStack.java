package main.datastructures;

import java.util.Iterator;

public class CustomStack<T> implements Iterable<T> {

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top = null; // Top of stack
    private int size = 0;

    // Add element to stack (push)
    public void push(T element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Remove and return top element (pop)
    public T pop() {
        if (top == null) {
            return null;
        }

        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // Peek top element without removing
    public T peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get size
    public int size() {
        return size;
    }

    // Display stack
    public void display() {
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
