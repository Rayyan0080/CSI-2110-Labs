/*
 * FILE EXPLANATION: 
 * This file defines the Task object that will be used as the value (V) in our Priority Queue.
 * It holds basic information about a task.
 * * TIME COMPLEXITIES FOR THIS FILE:
 * - Constructor: O(1)
 * - toString(): O(1)
 */

public class Task {
    // Explanation: A private String to hold the name of the task.
    private String taskName; 

    /*
     * FUNCTION EXPLANATION: Constructor to initialize the Task.
     * TIME COMPLEXITY: O(1)
     */
    public Task(String taskName) {
        // Explanation: Assigns the passed argument to the instance variable.
        this.taskName = taskName; 
    }

    /*
     * FUNCTION EXPLANATION: Returns the string representation of the task.
     * TIME COMPLEXITY: O(1)
     */
    @Override
    public String toString() {
        // Explanation: Returns the taskName string.
        return taskName; 
    }
}