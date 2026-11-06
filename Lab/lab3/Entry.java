/*
 * FILE EXPLANATION: 
 * This file creates the Entry<K,V> interface which represents a key-value pair 
 * stored in a priority queue. The key (K) acts as the priority, and the value (V) is the data.
 * * TIME COMPLEXITIES FOR THIS FILE:
 * - getKey(): O(1) (for implementations)
 * - getValue(): O(1) (for implementations)
 */

public interface Entry<K, V> {
    
    /*
     * FUNCTION EXPLANATION: Returns the key stored in this entry.
     * TIME COMPLEXITY: O(1)
     */
    // Explanation: Method signature for getting the key.
    K getKey(); 

    /*
     * FUNCTION EXPLANATION: Returns the value stored in this entry.
     * TIME COMPLEXITY: O(1)
     */
    // Explanation: Method signature for getting the value.
    V getValue(); 
}