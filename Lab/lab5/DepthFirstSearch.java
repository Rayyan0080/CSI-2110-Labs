import java.util.*; // Imports standard collections

/**
 * PURPOSE OF FILE: Implements Depth-First Search algorithms for reachability and cycle detection [cite: 622-642].
 * TIME COMPLEXITIES: Traversal, Reachability, and Cycle Detection are all $O(|V| + |E|)$.
 * WHAT IS IN IT: Iterative/Recursive traversal methods, a reachability check, and a cycle check.
 * HOW IT WORKS: Uses recursion (call stack) to explore as deeply as possible along each branch before backtracking.
 */
public class DepthFirstSearch { // Declares the DFS utility class

    /**
     * PURPOSE: Determines if a path exists between source and destination.
     * HOW IT WORKS: Wraps a standard DFS traversal; if the destination is visited during the traversal, it is reachable.
     * TIME COMPLEXITY: $O(|V| + |E|)$
     */
    public <V> boolean isReachable(Graph<V> graph, V source, V destination) { // Method signature for reachability testing [cite: 625]
        if (!graph.containsVertex(source) || !graph.containsVertex(destination)) return false; // Returns false if endpoints don't exist
        
        Set<V> visited = new HashSet<>(); // Set to track visited nodes
        dfsRecursive(graph, source, visited, destination); // Initiates the recursive DFS search
        
        return visited.contains(destination); // Returns true if the destination was added to the visited set [cite: 633]
    } // Ends method

    /**
     * PURPOSE: Recursive helper for DFS traversal.
     * HOW IT WORKS: Marks current node visited, then recursively calls itself on unvisited neighbors.
     * TIME COMPLEXITY: $O(|V| + |E|)$
     */
    private <V> void dfsRecursive(Graph<V> graph, V current, Set<V> visited, V target) { // Recursive helper method
        visited.add(current); // Marks the current node as visited immediately
        
        if (target != null && current.equals(target)) return; // Short-circuits the search if the target is found
        
        for (WeightedEdge<V> edge : graph.getOutgoingEdges(current)) { // Iterates through all neighbors
            V neighbor = edge.getDestination(); // Extracts neighbor vertex
            if (!visited.contains(neighbor)) { // Checks if it has been visited
                dfsRecursive(graph, neighbor, visited, target); // Recursively visits the neighbor
            } // Ends if block
        } // Ends for loop
    } // Ends method

    /**
     * PURPOSE: Detects if the graph contains any cycles.
     * HOW IT WORKS: Uses DFS with a tracking set for the current recursion stack (for directed graphs).
     * TIME COMPLEXITY: $O(|V| + |E|)$
     */
    public <V> boolean hasCycle(Graph<V> graph) { // Method signature for cycle detection [cite: 630]
        Set<V> visited = new HashSet<>(); // Set for globally visited nodes
        Set<V> recursionStack = new HashSet<>(); // Set to track nodes currently in the recursion stack
        
        for (V vertex : graph.getVertices()) { // Iterates over all vertices (handles disconnected components) [cite: 635]
            if (!visited.contains(vertex)) { // If vertex hasn't been checked
                if (checkCycleDFS(graph, vertex, visited, recursionStack)) { // Calls recursive cycle checker
                    return true; // Returns true immediately if a cycle is found
                } // Ends if block
            } // Ends if block
        } // Ends for loop
        return false; // Returns false if no cycles were found in any component
    } // Ends method

    /**
     * PURPOSE: Helper for cycle detection.
     * HOW IT WORKS: Adds node to stack; if we see a neighbor already on the stack, it's a back-edge (cycle).
     * TIME COMPLEXITY: $O(|V| + |E|)$
     */
    private <V> boolean checkCycleDFS(Graph<V> graph, V current, Set<V> visited, Set<V> recursionStack) { // Recursive cycle helper
        visited.add(current); // Marks node globally visited
        recursionStack.add(current); // Adds node to the current path stack
        
        for (WeightedEdge<V> edge : graph.getOutgoingEdges(current)) { // Iterates neighbors
            V neighbor = edge.getDestination(); // Gets destination
            if (!visited.contains(neighbor)) { // If not globally visited
                if (checkCycleDFS(graph, neighbor, visited, recursionStack)) return true; // Recursively check, pass cycle up if found
            } else if (recursionStack.contains(neighbor)) { // If visited AND currently in the stack...
                return true; // A back-edge is found, meaning a directed cycle exists [cite: 634]
            } // Ends if/else block
        } // Ends for loop
        
        recursionStack.remove(current); // Removes node from stack as we backtrack
        return false; // Returns false for this path
    } // Ends method
} // Ends class