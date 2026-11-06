import java.util.ArrayList;
import java.util.List;

/*
 * FILE EXPLANATION: 
 * This file implements an unsorted List-based Priority Queue. We insert items at the end of a list 
 * and search for the minimum element when min() or removeMin() is called.
 * * TIME COMPLEXITIES FOR THIS FILE:
 * - size(): O(1)
 * - isEmpty(): O(1)
 * - insert(): O(1)
 * - min(): O(n)
 * - removeMin(): O(n)
 */

public class ListPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    // Explanation: Inner class to implement the Entry interface.
    private static class PQEntry<K, V> implements Entry<K, V> {
        // Explanation: Stores the priority key.
        private K k; 
        // Explanation: Stores the task value.
        private V v; 
        
        // Explanation: Constructor for inner Entry class.
        public PQEntry(K key, V value) {
            // Explanation: Assigns key.
            k = key; 
            // Explanation: Assigns value.
            v = value; 
        }
        // Explanation: Returns the key.
        public K getKey() { return k; } 
        // Explanation: Returns the value.
        public V getValue() { return v; } 
    }

    // Explanation: The underlying list storing the entries.
    private List<Entry<K, V>> list = new ArrayList<>(); 

    /*
     * FUNCTION EXPLANATION: Returns the number of entries in the list.
     * TIME COMPLEXITY: O(1)
     */
    @Override
    public int size() {
        // Explanation: Returns the size of the ArrayList.
        return list.size(); 
    }

    /*
     * FUNCTION EXPLANATION: Returns true if the list size is 0.
     * TIME COMPLEXITY: O(1)
     */
    @Override
    public boolean isEmpty() {
        // Explanation: Returns true if the array list is empty.
        return list.isEmpty(); 
    }

    /*
     * FUNCTION EXPLANATION: Inserts a new element at the end of the unsorted list.
     * TIME COMPLEXITY: O(1) amortized
     */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        // Explanation: Creates a new entry object.
        Entry<K, V> newest = new PQEntry<>(key, value); 
        // Explanation: Adds the entry to the end of our list.
        list.add(newest); 
        // Explanation: Returns the newly created entry.
        return newest; 
    }

    /*
     * FUNCTION EXPLANATION: Finds the entry with the smallest key.
     * TIME COMPLEXITY: O(n)
     */
    private Entry<K, V> findMin() {
        // Explanation: If list is empty, return null.
        if (list.isEmpty()) return null; 
        // Explanation: Assume the first element is the minimum initially.
        Entry<K, V> min = list.get(0); 
        // Explanation: Loop through all entries in the list.
        for (Entry<K, V> entry : list) { 
            // Explanation: Compare current entry key with the minimum found so far.
            if (entry.getKey().compareTo(min.getKey()) < 0) { 
                // Explanation: If smaller, update the min reference.
                min = entry; 
            }
        }
        // Explanation: Return the minimum entry found.
        return min; 
    }

    /*
     * FUNCTION EXPLANATION: Returns the minimum entry without removing it.
     * TIME COMPLEXITY: O(n)
     */
    @Override
    public Entry<K, V> min() {
        // Explanation: Calls the helper method to find and return the min.
        return findMin(); 
    }

    /*
     * FUNCTION EXPLANATION: Finds, removes, and returns the minimum entry.
     * TIME COMPLEXITY: O(n)
     */
    @Override
    public Entry<K, V> removeMin() {
        // Explanation: Finds the minimum entry.
        Entry<K, V> min = findMin(); 
        // Explanation: If not null, removes it from the list.
        if (min != null) list.remove(min); 
        // Explanation: Returns the removed entry.
        return min; 
    }
}