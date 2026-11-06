import java.util.ArrayList;

/*
 * FILE EXPLANATION: 
 * This file implements a Min-Heap based Priority Queue using an ArrayList. 
 * It maintains the heap-order property using upheap and downheap operations.
 * * TIME COMPLEXITIES FOR THIS FILE:
 * - size(): O(1)
 * - isEmpty(): O(1)
 * - parent/left/right index calculations: O(1)
 * - swap: O(1)
 * - upheap: O(log n)
 * - downheap: O(log n)
 * - insert(): O(log n)
 * - min(): O(1)
 * - removeMin(): O(log n)
 * - displayHeap(): O(n)
 */

public class HeapPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    // Explanation: Inner class to implement the Entry interface.
    protected static class PQEntry<K, V> implements Entry<K, V> {
        // Explanation: Stores the key.
        private K k; 
        // Explanation: Stores the value.
        private V v; 
        // Explanation: Constructor.
        public PQEntry(K key, V value) { k = key; v = value; }
        // Explanation: Gets key.
        public K getKey() { return k; } 
        // Explanation: Gets value.
        public V getValue() { return v; } 
        // Explanation: Custom toString for displaying the heap easily.
        public String toString() { return "(" + k + "," + v.toString() + ")"; }
    }

    // Explanation: The arraylist that acts as the internal heap array.
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>(); 

    /*
     * FUNCTION EXPLANATION: Returns parent index.
     * TIME COMPLEXITY: O(1)
     */
    protected int parent(int j) { 
        // Explanation: Math formula for parent index in a 0-indexed array.
        return (j - 1) / 2; 
    }

    /*
     * FUNCTION EXPLANATION: Returns left child index.
     * TIME COMPLEXITY: O(1)
     */
    protected int left(int j) { 
        // Explanation: Math formula for left child index.
        return 2 * j + 1; 
    }

    /*
     * FUNCTION EXPLANATION: Returns right child index.
     * TIME COMPLEXITY: O(1)
     */
    protected int right(int j) { 
        // Explanation: Math formula for right child index.
        return 2 * j + 2; 
    }

    /*
     * FUNCTION EXPLANATION: Swaps two entries at given indices.
     * TIME COMPLEXITY: O(1)
     */
    protected void swap(int i, int j) {
        // Explanation: Store element i in a temp variable.
        Entry<K, V> temp = heap.get(i); 
        // Explanation: Put element j into index i.
        heap.set(i, heap.get(j)); 
        // Explanation: Put temp (element i) into index j.
        heap.set(j, temp); 
    }

    /*
     * FUNCTION EXPLANATION: Restores heap property by bubbling up a newly inserted element.
     * TIME COMPLEXITY: O(log n)
     */
    protected void upheap(int j) {
        // Explanation: Loop while j is not the root.
        while (j > 0) { 
            // Explanation: Find parent index.
            int p = parent(j); 
            // Explanation: If parent key is less than or equal to current key, heap is valid.
            if (heap.get(p).getKey().compareTo(heap.get(j).getKey()) <= 0) break; 
            // Explanation: Otherwise, swap child and parent.
            swap(j, p); 
            // Explanation: Move index j up to the parent.
            j = p; 
        }
    }

    /*
     * FUNCTION EXPLANATION: Restores heap property by bubbling down the root element.
     * TIME COMPLEXITY: O(log n)
     */
    protected void downheap(int j) {
        // Explanation: Loop while there is a left child.
        while (left(j) < heap.size()) { 
            // Explanation: Assume left child is the smallest.
            int leftIndex = left(j); 
            // Explanation: Variable to track smallest child index.
            int smallChildIndex = leftIndex; 
            // Explanation: Find right child index.
            int rightIndex = right(j); 
            // Explanation: If right child exists and is smaller than left child...
            if (rightIndex < heap.size() && heap.get(rightIndex).getKey().compareTo(heap.get(leftIndex).getKey()) < 0) {
                // Explanation: Update smallest child index to be the right child.
                smallChildIndex = rightIndex; 
            }
            // Explanation: If current node is smaller than or equal to smallest child, heap is valid.
            if (heap.get(smallChildIndex).getKey().compareTo(heap.get(j).getKey()) >= 0) break; 
            // Explanation: Swap current node with smallest child.
            swap(j, smallChildIndex); 
            // Explanation: Move index j down to the child.
            j = smallChildIndex; 
        }
    }

    /*
     * FUNCTION EXPLANATION: Returns size of heap.
     * TIME COMPLEXITY: O(1)
     */
    public int size() { 
        // Explanation: Returns size of the ArrayList.
        return heap.size(); 
    }

    /*
     * FUNCTION EXPLANATION: Returns true if heap is empty.
     * TIME COMPLEXITY: O(1)
     */
    public boolean isEmpty() { 
        // Explanation: Returns true if size is 0.
        return heap.isEmpty(); 
    }

    /*
     * FUNCTION EXPLANATION: Inserts new element, then upheaps to maintain heap property.
     * TIME COMPLEXITY: O(log n)
     */
    public Entry<K, V> insert(K key, V value) {
        // Explanation: Creates a new entry.
        Entry<K, V> newest = new PQEntry<>(key, value); 
        // Explanation: Adds to the end of the array (bottom of the tree).
        heap.add(newest); 
        // Explanation: Calls upheap on the last index to restore heap order.
        upheap(heap.size() - 1); 
        // Explanation: Returns the created entry.
        return newest; 
    }

    /*
     * FUNCTION EXPLANATION: Returns root of the heap (minimum element).
     * TIME COMPLEXITY: O(1)
     */
    public Entry<K, V> min() {
        // Explanation: If empty, return null.
        if (heap.isEmpty()) return null; 
        // Explanation: Return the first element (root).
        return heap.get(0); 
    }

    /*
     * FUNCTION EXPLANATION: Removes root, moves last element to root, then downheaps.
     * TIME COMPLEXITY: O(log n)
     */
    public Entry<K, V> removeMin() {
        // Explanation: If empty, return null.
        if (heap.isEmpty()) return null; 
        // Explanation: Store root to return later.
        Entry<K, V> answer = heap.get(0); 
        // Explanation: Swap root with the last element.
        swap(0, heap.size() - 1); 
        // Explanation: Remove the last element (which was the old root).
        heap.remove(heap.size() - 1); 
        // Explanation: Call downheap on new root to restore order.
        downheap(0); 
        // Explanation: Return the stored old root.
        return answer; 
    }

    /*
     * FUNCTION EXPLANATION: Utility to print the internal array for debugging/reporting.
     * TIME COMPLEXITY: O(n)
     */
    public void displayHeap() {
        // Explanation: Prints the string representation of the ArrayList.
        System.out.println("Internal Heap Array: " + heap.toString()); 
    }
}