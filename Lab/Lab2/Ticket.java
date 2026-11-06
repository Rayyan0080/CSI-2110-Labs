/**
 * Represents a basic ticket in the Ticket Processing System.
 */
public class Ticket { // Declares the public class named Ticket
    private int id; // Declares a private integer to store the ticket ID
    private String requester; // Declares a private String to store the name of the person who requested the ticket
    private String description; // Declares a private String to store a short description of the issue
    private int priority; // Declares a private integer to represent the priority level of the ticket

    /**
     * Constructor to initialize a new Ticket object.
     * Time Complexity: O(1)
     */
    public Ticket(int id, String requester, String description, int priority) { // Defines the constructor with parameters for all fields
        this.id = id; // Assigns the passed id parameter to the instance variable id
        this.requester = requester; // Assigns the passed requester parameter to the instance variable requester
        this.description = description; // Assigns the passed description parameter to the instance variable description
        this.priority = priority; // Assigns the passed priority parameter to the instance variable priority
    } // Ends the constructor block

    /**
     * Retrieves the ticket ID.
     * Time Complexity: O(1)
     */
    public int getId() { // Defines a public getter method for the id
        return id; // Returns the value stored in the id variable
    } // Ends the getId method

    /**
     * Retrieves the requester's name.
     * Time Complexity: O(1)
     */
    public String getRequester() { // Defines a public getter method for the requester
        return requester; // Returns the value stored in the requester variable
    } // Ends the getRequester method

    /**
     * Retrieves the ticket description.
     * Time Complexity: O(1)
     */
    public String getDescription() { // Defines a public getter method for the description
        return description; // Returns the value stored in the description variable
    } // Ends the getDescription method

    /**
     * Retrieves the ticket priority.
     * Time Complexity: O(1)
     */
    public int getPriority() { // Defines a public getter method for the priority
        return priority; // Returns the value stored in the priority variable
    } // Ends the getPriority method

    /**
     * Sets a new ticket ID.
     * Time Complexity: O(1)
     */
    public void setId(int id) { // Defines a public setter method for the id
        this.id = id; // Updates the instance variable id with the new passed value
    } // Ends the setId method

    /**
     * Sets a new requester name.
     * Time Complexity: O(1)
     */
    public void setRequester(String requester) { // Defines a public setter method for the requester
        this.requester = requester; // Updates the instance variable requester with the new passed value
    } // Ends the setRequester method

    /**
     * Sets a new ticket description.
     * Time Complexity: O(1)
     */
    public void setDescription(String description) { // Defines a public setter method for the description
        this.description = description; // Updates the instance variable description with the new passed value
    } // Ends the setDescription method

    /**
     * Sets a new ticket priority.
     * Time Complexity: O(1)
     */
    public void setPriority(int priority) { // Defines a public setter method for the priority
        this.priority = priority; // Updates the instance variable priority with the new passed value
    } // Ends the setPriority method

    /**
     * Returns a string representation of the ticket.
     * Time Complexity: O(1) (String concatenation overhead is constant here)
     */
    @Override // Annotation to indicate this method overrides the default Object toString method
    public String toString() { // Defines the public toString method returning a String
        return "Ticket #" + id + " [Priority: " + priority + ", Requester: " + requester + "] - " + description; // Constructs and returns the formatted string describing the ticket
    } // Ends the toString method
} // Ends the Ticket class