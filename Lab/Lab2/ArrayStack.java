/**
 * Array-based implementation of the Stack interface.
 */
public class ArrayStack<E> implements Stack<E> { // Declares a generic class ArrayStack that implements the Stack interface
    public static final int CAPACITY = 1000; // Declares a constant integer representing the default array capacity
    private E[] data; // Declares a private generic array to hold the stack elements
    private int t = -1; // Declares a private integer tracking the index of the top element, initialized to -1 (empty)

    /**
     * Default constructor.
     * Time Complexity: O(1)
     */
    public ArrayStack() { // Defines the default no-argument constructor
        this(CAPACITY); // Calls the parameterized constructor below, passing the default CAPACITY
    } // Ends the default constructor

    /**
     * Parameterized constructor.
     * Time Complexity: O(1) (Array allocation is O(1) in Java regarding initialization steps here)
     */
    @SuppressWarnings("unchecked") // Suppresses compiler warnings about unchecked generic array creation
    public ArrayStack(int capacity) { // Defines a constructor taking a custom capacity integer
        data = (E[]) new Object[capacity]; // Creates a new Object array of the given capacity and casts it to generic type E[]
    } // Ends the parameterized constructor

    /**
     * Returns the number of elements in the stack.
     * Time Complexity: O(1)
     */
    @Override // Indicates this method implements a method from the Stack interface
    public int size() { // Defines the public size method returning an integer
        return t + 1; // Returns the top index plus one to represent the actual element count
    } // Ends the size method

    /**
     * Checks if the stack is empty.
     * Time Complexity: O(1)
     */
    @Override // Indicates this method implements a method from the Stack interface
    public boolean isEmpty() { // Defines the public isEmpty method returning a boolean
        return t == -1; // Returns true if the top index is -1, meaning no elements exist
    } // Ends the isEmpty method

    /**
     * Adds an element to the top of the stack.
     * Time Complexity: O(1)
     */
    @Override // Indicates this method implements a method from the Stack interface
    public void push(E e) throws IllegalStateException { // Defines the public push method, which may throw an exception if full
        if (size() == data.length) { // Checks if the current size equals the maximum array capacity
            throw new IllegalStateException("Stack is full"); // Throws an exception because this implementation does not resize
        } // Ends the if condition
        data[++t] = e; // Increments the top index (t) by 1 first, then assigns the new element 'e' to that array position
    } // Ends the push method

    /**
     * Returns the top element without removing it.
     * Time Complexity: O(1)
     */
    @Override // Indicates this method implements a method from the Stack interface
    public E top() { // Defines the public top method returning an element of type E
        if (isEmpty()) return null; // Checks if the stack is empty; if so, returns null immediately
        return data[t]; // Returns the element located at the current top index 't'
    } // Ends the top method

    /**
     * Removes and returns the top element from the stack.
     * Time Complexity: O(1)
     */
    @Override // Indicates this method implements a method from the Stack interface
    public E pop() { // Defines the public pop method returning an element of type E
        if (isEmpty()) return null; // Checks if the stack is empty; if so, returns null immediately
        E answer = data[t]; // Stores the element currently at the top index 't' in a temporary variable named 'answer'
        data[t] = null; // Sets the array slot at index 't' to null to allow the garbage collector to free up memory
        t--; // Decrements the top index 't' by 1 to point to the new top element
        return answer; // Returns the removed element stored in 'answer'
    } // Ends the pop method
} // Ends the ArrayStack class