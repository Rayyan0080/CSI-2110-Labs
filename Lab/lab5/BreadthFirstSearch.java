import java.util.*; // Imports standard collections

/**
 * PURPOSE OF FILE: Implements Breadth-First Search algorithms for traversal and shortest-path (by edge count) [cite: 601-621].
 * TIME COMPLEXITIES: Traversal and Pathfinding are $O(|V| + |E|)$ using an adjacency list.
 * WHAT IS IN IT: Methods to traverse the graph level-by-level and to reconstruct the minimum-edge path.
 * HOW IT WORKS: Uses a FIFO Queue to explore nearest neighbors before moving deeper.
 */
public class BreadthFirstSearch { // Declares the BFS utility class

    /**
     * PURPOSE: Finds a path with the minimum number of edges between source and destination.
     * HOW IT WORKS: Executes standard BFS while recording predecessors, then backtracks from destination.
     * TIME COMPLEXITY: $O(|V| + |E|)$
     */
    public <V> List<V> breadthFirstPath(Graph<V> graph, V source, V destination) { // Method signature for BFS pathfinding [cite: 604]
        if (!graph.containsVertex(source) || !graph.containsVertex(destination)) return Collections.emptyList(); // Returns empty if endpoints are invalid [cite: 618]
        
        Queue<V> queue = new ArrayDeque<>(); // Initializes a FIFO queue for processing vertices
        Set<V> visited = new HashSet<>(); // Initializes a set to track visited vertices to prevent infinite loops [cite: 609]
        Map<V, V> predecessors = new HashMap<>(); // Initializes a map to store where each visited vertex came from [cite: 609]
        
        queue.add(source); // Enqueues the starting vertex
        visited.add(source); // Marks the starting vertex as visited
        
        while (!queue.isEmpty()) { // Loops as long as there are vertices to process
            V current = queue.poll(); // Dequeues the next vertex in line
            
            if (current.equals(destination)) { // Checks if we have reached our target [cite: 616]
                break; // Exits the loop early since we found the shortest path (by edges)
            } // Ends if block
            
            // Note: For deterministic neighbor order, we assume the graph returns edges in a consistent order [cite: 609]
            for (WeightedEdge<V> edge : graph.getOutgoingEdges(current)) { // Iterates through all outgoing edges of the current vertex
                V neighbor = edge.getDestination(); // Extracts the destination vertex from the edge
                if (!visited.contains(neighbor)) { // Checks if this neighbor hasn't been seen yet
                    visited.add(neighbor); // Marks the neighbor as visited
                    predecessors.put(neighbor, current); // Records the current vertex as the predecessor of the neighbor
                    queue.add(neighbor); // Enqueues the neighbor for future processing
                } // Ends if block
            } // Ends for loop
        } // Ends while loop
        
        return reconstructPath(source, destination, predecessors); // Calls helper function to build the final list
    } // Ends method

    /**
     * PURPOSE: Reconstructs the path from predecessors map.
     * HOW IT WORKS: Starts at destination and traces backwards to source, then reverses the list.
     * TIME COMPLEXITY: $O(|V|)$ in the worst case where the path visits all nodes.
     */
    private <V> List<V> reconstructPath(V source, V destination, Map<V, V> predecessors) { // Helper to build path
        List<V> path = new ArrayList<>(); // Initializes list to hold the path
        V current = destination; // Starts backtracking from the destination
        
        while (current != null) { // Loops until we hit a vertex with no predecessor (or source)
            path.add(current); // Adds the current vertex to the path
            if (current.equals(source)) break; // Stops if we've reached the source
            current = predecessors.get(current); // Moves to the predecessor
        } // Ends while loop
        
        if (path.isEmpty() || !path.get(path.size() - 1).equals(source)) { // Checks if the path actually reached the source (validates reachability)
            return Collections.emptyList(); // Returns empty if destination was unreachable [cite: 617]
        } // Ends if block
        
        Collections.reverse(path); // Reverses the list so it goes from source -> destination
        return path; // Returns the final reconstructed path
    } // Ends method
} // Ends class