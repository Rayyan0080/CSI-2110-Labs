public class DoublyIntegerList {
    private static class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) { this.data = data; }
    }

    private final Node header;
    private final Node trailer;
    private int size = 0;

    public DoublyIntegerList() {
        header = new Node(0);
        trailer = new Node(0);
        header.next = trailer;
        trailer.prev = header;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    private void addBetween(int value, Node predecessor, Node successor) {
        Node newest = new Node(value);
        newest.prev = predecessor;
        newest.next = successor;
        predecessor.next = newest;
        successor.prev = newest;
        size++;
    }

    private int remove(Node node) {
        Node predecessor = node.prev;
        Node successor = node.next;
        predecessor.next = successor;
        successor.prev = predecessor;
        size--;
        return node.data;
    }

    public void addFirst(int value) {
        addBetween(value, header, header.next);
    }

    public void addLast(int value) {
        addBetween(value, trailer.prev, trailer);
    }

    public int removeFirst() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return remove(header.next);
    }

    public int removeLast() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return remove(trailer.prev);
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        Node current = header.next;
        while (current != trailer) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}