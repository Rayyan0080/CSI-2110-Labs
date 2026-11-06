/**
 * File: SimpleSort.java
 * Purpose: Implements Insertion Sort to act as the "simple sorting algorithm" baseline for comparison.
 * Overall Time Complexity: O(n^2) in the worst and average cases, O(n) in the best case (already sorted).
 * Overall Space Complexity: O(1) because it sorts the array in-place.
 */
public class SimpleSort { // Declares the public class SimpleSort[cite: 383].

    /**
     * Function: insertionSort
     * Time Complexity: O(n^2) worst case, O(n) best case.
     * Purpose: Sorts an array of StudentRecord objects by grade using the insertion method.
     */
    public static void insertionSort(StudentRecord[] array) { // Defines the static insertionSort method.
        int n = array.length; // Retrieves the total length of the array to sort.
        
        for (int i = 1; i < n; ++i) { // Loops starting from the second element (index 1) to the end.
            StudentRecord key = array[i]; // Stores the current element to be positioned as the 'key'.
            int j = i - 1; // Initializes a pointer 'j' to the element just before the key.

            // Moves elements of the sorted segment (0 to i-1) that are greater than the key to one position ahead.
            while (j >= 0 && array[j].getGrade() > key.getGrade()) { // Loops backwards as long as elements are larger than the key.
                array[j + 1] = array[j]; // Shifts the larger element one position to the right.
                j = j - 1; // Decrements 'j' to check the next element to the left.
            } // Ends the while loop for shifting elements.
            
            array[j + 1] = key; // Places the key into its correct sorted position within the sorted segment.
        } // Ends the main for loop.
    } // Ends the insertionSort method.
} // Ends the SimpleSort class.