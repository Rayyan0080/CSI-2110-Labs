/*
 * FILE EXPLANATION: 
 * This file creates the PriorityQueue<K,V> interface defining the standard 
 * Priority Queue ADT methods required by the lab specifications.
 * * TIME COMPLEXITIES FOR THIS FILE (Expected in standard implementations):
 * - size(): O(1)
 * - isEmpty(): O(1)
 * - insert(): Varies (O(1) to O(log n) or O(n) depending on implementation)
 * - min(): Varies (O(1) to O(n))
 * - removeMin(): Varies (O(log n) to O(n))
 */

public interface PriorityQueue<K, V> {
    
    /*
     * FUNCTION EXPLANATION: Returns the number of items in the priority queue.
     * TIME COMPLEXITY: O(1)
     */
    // Explanation: Method signature for size.
    int size(); 

    /*
     * FUNCTION EXPLANATION: Checks if the priority queue is empty.
     * TIME COMPLEXITY: O(1)
     */
    // Explanation: Method signature returning boolean for emptiness.
    boolean isEmpty(); 

    /*
     * FUNCTION EXPLANATION: Inserts a key-value pair into the priority queue.
     * TIME COMPLEXITY: Implementation dependent.
     */
    // Explanation: Method signature for inserting entry, returning the created Entry.
    Entry<K, V> insert(K key, V value) throws IllegalArgumentException; 

    /*
     * FUNCTION EXPLANATION: Returns (but does not remove) the entry with the smallest key.
     * TIME COMPLEXITY: Implementation dependent.
     */
    // Explanation: Method signature to get minimum entry.
    Entry<K, V> min(); 

    /*
     * FUNCTION EXPLANATION: Removes and returns the entry with the smallest key.
     * TIME COMPLEXITY: Implementation dependent.
     */
    // Explanation: Method signature to remove and return minimum entry.
    Entry<K, V> removeMin(); 
}