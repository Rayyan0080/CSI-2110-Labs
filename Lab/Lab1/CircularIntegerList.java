public class CircularIntegerList {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node tail = null;
    private int size = 0;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.next; // The old head becomes the new tail
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        Node head = tail.next;
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}