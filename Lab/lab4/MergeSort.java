/**
 * File: MergeSort.java
 * Purpose: Implements the Merge-Sort algorithm to sort an array of StudentRecord objects by grade.
 * Overall Time Complexity: O(n log n) for all cases (best, average, worst).
 * Overall Space Complexity: O(n) due to the temporary arrays created during the merge step.
 */
public class MergeSort { // Declares the public class MergeSort[cite: 329].

    /**
     * Function: sort
     * Time Complexity: O(n log n)
     * Purpose: The main recursive function that divides the array into halves.
     */
    public static void sort(StudentRecord[] array, int left, int right) { // Defines the recursive sort method.
        if (left < right) { // Checks if the sub-array has more than one element (base case).
            // DIVIDE STEP
            int mid = left + (right - left) / 2; // Calculates the middle index to prevent integer overflow.
            
            // CONQUER STEP
            sort(array, left, mid); // Recursively calls sort on the left half of the array.
            sort(array, mid + 1, right); // Recursively calls sort on the right half of the array.
            
            // COMBINE STEP
            merge(array, left, mid, right); // Calls the merge helper function to combine the sorted halves.
        } // Ends the if condition.
    } // Ends the sort method.

    /**
     * Function: merge
     * Time Complexity: O(n) where n is the number of elements being merged.
     * Purpose: Combines two sorted sub-arrays back into a single sorted array.
     */
    private static void merge(StudentRecord[] array, int left, int mid, int right) { // Defines the merge helper method[cite: 332].
        int n1 = mid - left + 1; // Calculates the size of the left sub-array.
        int n2 = right - mid; // Calculates the size of the right sub-array.

        StudentRecord[] leftArray = new StudentRecord[n1]; // Creates a temporary array for the left half.
        StudentRecord[] rightArray = new StudentRecord[n2]; // Creates a temporary array for the right half.

        for (int i = 0; i < n1; ++i) { // Loops through the left sub-array size.
            leftArray[i] = array[left + i]; // Copies data from the main array to the left temporary array.
        } // Ends the left copy loop.
        for (int j = 0; j < n2; ++j) { // Loops through the right sub-array size.
            rightArray[j] = array[mid + 1 + j]; // Copies data from the main array to the right temporary array.
        } // Ends the right copy loop.

        int i = 0; // Initializes a pointer for the left temporary array.
        int j = 0; // Initializes a pointer for the right temporary array.
        int k = left; // Initializes a pointer for the main merged array.

        while (i < n1 && j < n2) { // Loops as long as both temporary arrays have unmerged elements.
            if (leftArray[i].getGrade() <= rightArray[j].getGrade()) { // Compares grades; if left is smaller or equal (ascending order).
                array[k] = leftArray[i]; // Places the smaller left element into the main array.
                i++; // Increments the left array pointer.
            } else { // If the right element's grade is smaller.
                array[k] = rightArray[j]; // Places the smaller right element into the main array.
                j++; // Increments the right array pointer.
            } // Ends the if-else block.
            k++; // Increments the main array pointer.
        } // Ends the main merge loop.

        while (i < n1) { // Loops to copy any remaining elements from the left array.
            array[k] = leftArray[i]; // Copies the element to the main array.
            i++; // Increments the left array pointer.
            k++; // Increments the main array pointer.
        } // Ends the left remainder loop.

        while (j < n2) { // Loops to copy any remaining elements from the right array.
            array[k] = rightArray[j]; // Copies the element to the main array.
            j++; // Increments the right array pointer.
            k++; // Increments the main array pointer.
        } // Ends the right remainder loop.
    } // Ends the merge method.
} // Ends the MergeSort class.