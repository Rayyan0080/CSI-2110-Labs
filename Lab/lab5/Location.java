/**
 * PURPOSE OF FILE: Represents a physical location in the MiniMap network [cite: 79-93].
 * TIME COMPLEXITIES: All operations (getters, equals, hashCode) are $O(1)$ [cite: 776-783].
 * WHAT IS IN IT: Fields for ID and name, constructor, getters, and standard object overrides [cite: 82-93].
 * HOW IT WORKS: Acts as an immutable data object to uniquely identify vertices in the graph[cite: 94].
 */
public class Location { // Declares the public Location class
    private final String id; // Declares an immutable string for the unique location identifier
    private final String name; // Declares an immutable string for the location's descriptive name

    /**
     * PURPOSE: Constructs a new Location instance.
     * HOW IT WORKS: Assigns the provided parameters to the internal final fields.
     * TIME COMPLEXITY: $O(1)$
     */
    public Location(String id, String name) { // Constructor accepting an ID and a name
        this.id = id; // Assigns the passed id parameter to the instance variable
        this.name = name; // Assigns the passed name parameter to the instance variable
    } // Ends the constructor

    /**
     * PURPOSE: Retrieves the location's ID.
     * HOW IT WORKS: Returns the internal id string.
     * TIME COMPLEXITY: $O(1)$
     */
    public String getId() { // Getter method for the id
        return id; // Returns the unique identifier string
    } // Ends the getId method

    /**
     * PURPOSE: Retrieves the location's name.
     * HOW IT WORKS: Returns the internal name string.
     * TIME COMPLEXITY: $O(1)$
     */
    public String getName() { // Getter method for the name
        return name; // Returns the descriptive name string
    } // Ends the getName method

    /**
     * PURPOSE: Checks if two locations are equal.
     * HOW IT WORKS: Compares the unique IDs of the locations[cite: 94].
     * TIME COMPLEXITY: $O(1)$ assuming string length is bounded
     */
    @Override // Indicates this overrides the standard Object.equals method
    public boolean equals(Object o) { // Accepts an object to compare against
        if (this == o) return true; // Returns true immediately if they are the exact same instance in memory
        if (o == null || getClass() != o.getClass()) return false; // Returns false if the other object is null or a different class
        Location location = (Location) o; // Casts the object to a Location instance
        return id.equals(location.id); // Returns the result of comparing their unique IDs
    } // Ends the equals method

    /**
     * PURPOSE: Generates a hash code for the location.
     * HOW IT WORKS: Hashes the unique ID string.
     * TIME COMPLEXITY: $O(1)$
     */
    @Override // Indicates this overrides the standard Object.hashCode method
    public int hashCode() { // Method to return an integer hash code
        return id.hashCode(); // Defers to the standard String hashCode implementation using the ID
    } // Ends the hashCode method

    /**
     * PURPOSE: Provides a readable string representation.
     * HOW IT WORKS: Combines the name and ID into a formatted string.
     * TIME COMPLEXITY: $O(1)$
     */
    @Override // Indicates this overrides the standard Object.toString method
    public String toString() { // Method to return a string representation
        return name + " (" + id + ")"; // Concatenates the name and ID with formatting parentheses
    } // Ends the toString method
} // Ends the Location class