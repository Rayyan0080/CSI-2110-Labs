

public interface IntegerSequence {
    void addFirst(int value);
    void addLast(int value);
    int removeFirst();
    boolean contains(int value);
    int size();
    boolean isEmpty();
    int get(int index);
    void printSequence();
}