/**
 * PURPOSE OF FILE: Represents a directed, weighted connection between two vertices [cite: 96-109].
 * TIME COMPLEXITIES: All operations (constructor, getters) are $O(1)$.
 * WHAT IS IN IT: A generic class containing a source vertex, destination vertex, and a double weight.
 * HOW IT WORKS: Stores the structural and cost relationship from one node to another.
 */
public class WeightedEdge<V> { // Declares a generic public class for a weighted edge
    private final V source; // Immutable reference to the starting vertex
    private final V destination; // Immutable reference to the ending vertex
    private final double weight; // Immutable primitive double representing the cost/distance

    /**
     * PURPOSE: Initializes a weighted edge.
     * HOW IT WORKS: Assigns input parameters to final fields.
     * TIME COMPLEXITY: $O(1)$
     */
    public WeightedEdge(V source, V destination, double weight) { // Constructor accepting source, destination, and weight
        this.source = source; // Assigns the source parameter to the instance variable
        this.destination = destination; // Assigns the destination parameter to the instance variable
        this.weight = weight; // Assigns the weight parameter to the instance variable
    } // Ends constructor

    /**
     * PURPOSE: Gets the source vertex.
     * HOW IT WORKS: Returns internal field.
     * TIME COMPLEXITY: $O(1)$
     */
    public V getSource() { // Getter for the source vertex
        return source; // Returns the starting vertex
    } // Ends method

    /**
     * PURPOSE: Gets the destination vertex.
     * HOW IT WORKS: Returns internal field.
     * TIME COMPLEXITY: $O(1)$
     */
    public V getDestination() { // Getter for the destination vertex
        return destination; // Returns the ending vertex
    } // Ends method

    /**
     * PURPOSE: Gets the edge weight.
     * HOW IT WORKS: Returns internal field.
     * TIME COMPLEXITY: $O(1)$
     */
    public double getWeight() { // Getter for the weight value
        return weight; // Returns the numerical cost of the edge
    } // Ends method
} // Ends class