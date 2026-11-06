/*
 * FILE EXPLANATION: 
 * This is the main class used to test our priority queues with at least 8 Task objects,
 * meeting the lab testing requirements.
 * * TIME COMPLEXITIES:
 * - main(): O(n log n) total for testing n insertions and removals in a heap.
 */
public class MainTester {
    /*
     * FUNCTION EXPLANATION: Main method to run the tests.
     */
    public static void main(String[] args) {
        // Explanation: Instantiates the Heap-based priority queue.
        HeapPriorityQueue<Integer, Task> hpq = new HeapPriorityQueue<>();

        // Explanation: Print header for testing.
        System.out.println("--- Testing Heap Priority Queue ---");

        // Explanation: Insert Task 1.
        hpq.insert(5, new Task("Clean Room"));
        // Explanation: Insert Task 2.
        hpq.insert(1, new Task("Do CSI 2110 Lab"));
        // Explanation: Insert Task 3.
        hpq.insert(9, new Task("Watch TV"));
        // Explanation: Insert Task 4.
        hpq.insert(3, new Task("Grocery Shopping"));
        // Explanation: Insert Task 5.
        hpq.insert(7, new Task("Go to Gym"));
        // Explanation: Insert Task 6.
        hpq.insert(2, new Task("Call Mom"));
        // Explanation: Insert Task 7.
        hpq.insert(8, new Task("Read Book"));
        // Explanation: Insert Task 8.
        hpq.insert(4, new Task("Pay Bills"));

        // Explanation: Call custom method to show internal array structure.
        hpq.displayHeap();

        // Explanation: Test min() without removing.
        System.out.println("Minimum element is: " + hpq.min().getValue());

        // Explanation: Test removeMin() in a loop to show sorting behavior.
        System.out.println("Removing elements in priority order:");
        // Explanation: Loop until queue is empty.
        while(!hpq.isEmpty()) {
            // Explanation: Remove and print the minimum priority task.
            System.out.println(hpq.removeMin().getValue());
        }
    }
}