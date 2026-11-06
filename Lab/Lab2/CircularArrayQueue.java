/**
 * A dynamic circular-array implementation of the Queue interface.
 */
public class CircularArrayQueue<E> implements Queue<E> { // Declares a generic class CircularArrayQueue that implements the Queue interface
    private E[] data; // Declares a private generic array to hold the queue elements
    private int f = 0;  // Declares a private integer tracking the index of the front element, initialized to 0
    private int sz = 0; // Declares a private integer tracking the current number of elements, initialized to 0
    private static final int DEFAULT_CAPACITY = 10; // Declares a constant integer for the default array size

    /**
     * Default constructor.
     * Time Complexity: O(1)
     */
    public CircularArrayQueue() { // Defines the default no-argument constructor
        this(DEFAULT_CAPACITY); // Calls the parameterized constructor below, passing the default capacity
    } // Ends the default constructor

    /**
     * Parameterized constructor.
     * Time Complexity: O(1)
     */
    @SuppressWarnings("unchecked") // Suppresses compiler warnings about unchecked generic array creation
    public CircularArrayQueue(int capacity) { // Defines a constructor taking a custom capacity integer
        data = (E[]) new Object[capacity]; // Creates a new Object array of the given capacity and casts it to generic type E[]
    } // Ends the parameterized constructor

    /**
     * Returns the number of elements in the queue.
     * Time Complexity: O(1)
     */
    @Override // Indicates this method implements a method from the Queue interface
    public int size() { // Defines the public size method returning an integer
        return sz; // Returns the tracking variable 'sz' representing the current number of elements
    } // Ends the size method

    /**
     * Checks if the queue is empty.
     * Time Complexity: O(1)
     */
    @Override // Indicates this method implements a method from the Queue interface
    public boolean isEmpty() { // Defines the public isEmpty method returning a boolean
        return sz == 0; // Returns true if the size variable 'sz' is exactly 0
    } // Ends the isEmpty method

    /**
     * Adds an element to the rear of the queue. Resizes if full.
     * Time Complexity: O(1) amortized (O(n) worst case if resizing is triggered)
     */
    @Override // Indicates this method implements a method from the Queue interface
    public void enqueue(E e) { // Defines the public enqueue method taking an element 'e'
        if (sz == data.length) { // Checks if the current size equals the full length of the underlying array
            resize(2 * data.length); // If full, calls the resize method to double the capacity of the array
        } // Ends the if condition
        int avail = (f + sz) % data.length; // Calculates the next available index by adding size to front index and using modulo to wrap around
        data[avail] = e; // Assigns the new element 'e' into the calculated available slot
        sz++; // Increments the size counter by 1
    } // Ends the enqueue method

    /**
     * Returns the front element without removing it.
     * Time Complexity: O(1)
     */
    @Override // Indicates this method implements a method from the Queue interface
    public E first() { // Defines the public first method returning an element of type E
        if (isEmpty()) return null; // Checks if the queue is empty; if so, returns null immediately
        return data[f]; // Returns the element located at the front index 'f'
    } // Ends the first method

    /**
     * Removes and returns the front element.
     * Time Complexity: O(1)
     */
    @Override // Indicates this method implements a method from the Queue interface
    public E dequeue() { // Defines the public dequeue method returning an element of type E
        if (isEmpty()) return null; // Checks if the queue is empty; if so, returns null immediately
        E answer = data[f]; // Stores the element currently at the front index 'f' in a temporary variable named 'answer'
        data[f] = null; // Sets the array slot at index 'f' to null to allow garbage collection of the removed object
        f = (f + 1) % data.length; // Advances the front index by 1, using modulo array length to wrap around to the beginning if necessary
        sz--; // Decrements the size counter by 1
        return answer; // Returns the removed element stored in 'answer'
    } // Ends the dequeue method

    /**
     * Resizes the underlying array and realigns elements.
     * Time Complexity: O(n) where n is the number of elements in the queue
     */
    @SuppressWarnings("unchecked") // Suppresses compiler warnings about unchecked generic array creation
    private void resize(int capacity) { // Defines a private helper method to resize the array to a new 'capacity'
        E[] temp = (E[]) new Object[capacity]; // Creates a new larger Object array and casts it to generic type E[]
        for (int i = 0; i < sz; i++) { // Starts a for loop to iterate 'sz' times, copying each existing element
            temp[i] = data[(f + i) % data.length]; // Copies elements from the old array (calculating their wrapped indices) into the new array starting from index 0
        } // Ends the for loop
        data = temp; // Replaces the old array reference with the new, larger array reference
        f = 0; // Resets the front index to 0, since elements were copied to the beginning of the new array
    } // Ends the resize method
} // Ends the CircularArrayQueue class