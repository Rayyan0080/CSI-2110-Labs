/**
 * A generic interface for a Queue data structure.
 */
public interface Queue<E> { // Declares a generic public interface named Queue holding elements of type E
    
    /** Returns the number of elements in the queue. Expected O(1) */
    int size(); // Method signature to return the integer size of the queue
    
    /** Tests whether the queue is empty. Expected O(1) */
    boolean isEmpty(); // Method signature to return true if empty, false otherwise
    
    /** Inserts an element at the rear of the queue. Expected O(1) (or amortized O(1) if resizing) */
    void enqueue(E e); // Method signature to add element e to the back of the queue
    
    /** Returns, but does not remove, the first element of the queue. Expected O(1) */
    E first(); // Method signature to return the front element of type E
    
    /** Removes and returns the first element of the queue. Expected O(1) */
    E dequeue(); // Method signature to remove and return the front element of type E
} // Ends the Queue interface