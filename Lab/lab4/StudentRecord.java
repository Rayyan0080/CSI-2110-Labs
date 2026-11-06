/**
 * File: StudentRecord.java
 * Purpose: Defines the data model for a student, containing their details and grades.
 * Time Complexity: O(1) for all methods since they are simple assignments and retrievals.
 * Space Complexity: O(1) auxiliary space per object.
 */
public class StudentRecord { // Declares the public class StudentRecord.
    private int studentNumber; // Declares a private integer for the student's ID[cite: 315].
    private String name; // Declares a private String for the student's name[cite: 316].
    private double grade; // Declares a private double for the student's grade[cite: 317].
    private int submissionTime; // Declares a private integer for the submission timestamp[cite: 318].

    /**
     * Function: Constructor
     * Time Complexity: O(1)
     * Purpose: Initializes a new StudentRecord object with the provided values.
     */
    public StudentRecord(int studentNumber, String name, double grade, int submissionTime) { // Constructor definition taking 4 parameters.
        this.studentNumber = studentNumber; // Assigns the passed studentNumber to the instance variable.
        this.name = name; // Assigns the passed name to the instance variable.
        this.grade = grade; // Assigns the passed grade to the instance variable.
        this.submissionTime = submissionTime; // Assigns the passed submissionTime to the instance variable.
    } // Ends the constructor.

    /**
     * Function: getGrade
     * Time Complexity: O(1)
     * Purpose: Returns the student's grade, which will be used as the key for sorting.
     */
    public double getGrade() { // Defines a public method returning a double.
        return grade; // Returns the value of the grade instance variable.
    } // Ends the getGrade method.

    /**
     * Function: toString
     * Time Complexity: O(1)
     * Purpose: Converts the student record into a readable string format for output.
     */
    @Override // Annotates that this overrides the default Object toString method.
    public String toString() { // Defines a public method returning a String[cite: 319].
        return studentNumber + " " + name + " " + grade; // Concatenates and returns the student details as a formatted string.
    } // Ends the toString method.
} // Ends the StudentRecord class.