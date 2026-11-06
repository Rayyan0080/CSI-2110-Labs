import java.util.List; // Imports the standard Java List interface

/**
 * PURPOSE OF FILE: Defines the Graph Abstract Data Type interface [cite: 176-190].
 * TIME COMPLEXITIES: N/A (Interface definition).
 * WHAT IS IN IT: Signatures for core graph operations (add/remove vertices and edges, querying state).
 * HOW IT WORKS: Establishes a contract that any specific graph implementation (like AdjacencyList) must fulfill.
 */
public interface Graph<V> { // Declares a public generic interface for the Graph ADT
    boolean addVertex(V vertex); // Signature to add a vertex; returns true if successful [cite: 178]
    boolean removeVertex(V vertex); // Signature to remove a vertex; returns true if successful [cite: 179]
    boolean addEdge(V source, V destination, double weight); // Signature to add a weighted edge [cite: 180]
    boolean removeEdge(V source, V destination); // Signature to remove an edge between two vertices [cite: 181]
    boolean containsVertex(V vertex); // Signature to check if a vertex exists in the graph [cite: 182]
    boolean containsEdge(V source, V destination); // Signature to check if an edge exists [cite: 183]
    List<V> getVertices(); // Signature to retrieve a list of all vertices [cite: 184]
    List<V> getNeighbors(V vertex); // Signature to retrieve all destination vertices from a given source [cite: 185]
    List<WeightedEdge<V>> getOutgoingEdges(V vertex); // Signature to get all edge objects originating from a vertex [cite: 186]
    int vertexCount(); // Signature to get the total number of vertices [cite: 187]
    int edgeCount(); // Signature to get the total number of directed edges [cite: 188]
    boolean isDirected(); // Signature to check if the graph is strictly directed [cite: 189]
} // Ends interface