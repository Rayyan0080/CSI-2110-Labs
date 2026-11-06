public class LinkedIntegerSequence implements IntegerSequence {
    
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedIntegerSequence() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty sequence.");
        }
        int removedValue = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return removedValue;
    }

    @Override
    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void printSequence() {
        if (isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next == null ? "" : " "));
            current = current.next;
        }
        System.out.println();
    }

    // ==========================================
    // PART D: RECURSIVE METHODS IMPLEMENTATION
    // ==========================================

    public int recursiveSum() {
        return recursiveSumHelper(head);
    }

    private int recursiveSumHelper(Node node) {
        if (node == null) return 0;
        return node.data + recursiveSumHelper(node.next);
    }

    public int recursiveMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot compute max of an empty sequence.");
        }
        return recursiveMaxHelper(head, head.data);
    }

    private int recursiveMaxHelper(Node node, int currentMax) {
        if (node == null) return currentMax;
        int newMax = Math.max(currentMax, node.data);
        return recursiveMaxHelper(node.next, newMax);
    }

    public void recursivePrintReverse() {
        recursivePrintReverseHelper(head);
        System.out.println();
    }

    private void recursivePrintReverseHelper(Node node) {
        if (node == null) return;
        recursivePrintReverseHelper(node.next);
        System.out.print(node.data + " ");
    }
}