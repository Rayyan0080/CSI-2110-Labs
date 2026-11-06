/**
 * A generic interface for a Stack data structure.
 */
public interface Stack<E> { // Declares a generic public interface named Stack holding elements of type E
    
    /** Returns the number of elements in the stack. Expected O(1) */
    int size(); // Method signature to return the integer size of the stack
    
    /** Tests whether the stack is empty. Expected O(1) */
    boolean isEmpty(); // Method signature to return true if empty, false otherwise
    
    /** Inserts an element at the top of the stack. Expected O(1) */
    void push(E e); // Method signature to add element e to the top of the stack
    
    /** Returns, but does not remove, the element at the top of the stack. Expected O(1) */
    E top(); // Method signature to return the top element of type E
    
    /** Removes and returns the top element from the stack. Expected O(1) */
    E pop(); // Method signature to remove and return the top element of type E
} // Ends the Stack interface