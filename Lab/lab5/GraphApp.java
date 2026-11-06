import java.util.*; // Imports the standard Java collections framework classes

/**
 * PURPOSE OF FILE: Contains the complete Graph Structure, Traversals (BFS/DFS), and Unit Tests for Person 1 [cite: 79-190].
 * TIME COMPLEXITIES: Overall time complexities are O(|V| + |E|) for most traversals. See individual classes/methods for details.
 * WHAT IS IN IT: Location, WeightedEdge, Graph (ADT), AdjacencyListGraph, BreadthFirstSearch, DepthFirstSearch, and GraphApp (Tests).
 * HOW IT WORKS: Defines a graph architecture using adjacency lists, provides traversal algorithms, and tests them via the main method.
 */
public class GraphApp { // Declares the public main class to run the tests

    /**
     * PURPOSE: Main entry point to execute all graph and traversal tests.
     * HOW IT WORKS: Calls individual static test methods and prints success messages.
     * TIME COMPLEXITY: O(|V| + |E|) overall for all tests combined.
     */
    public static void main(String[] args) { // Main method signature
        testEmptyGraph(); // Executes the empty graph test
        testVertexInsertionAndDuplicates(); // Executes the vertex insertion test
        testEdgeInsertionAndVerification(); // Executes the edge insertion test
        testBFSMinimumEdgePath(); // Runs the BFS path test
        testDFSReachability(); // Runs the DFS reachability test
        testDFSCycleDetection(); // Runs the DFS cycle detection test
        System.out.println("ALL TESTS PASSED SUCCESSFULLY! The Graph, BFS, and DFS implementations work as expected."); // Prints success if no errors occurred
    } // Ends main method

    // --- GRAPH ADT TESTS ---

    /**
     * PURPOSE: Tests the behavior of a newly created, empty graph.
     * HOW IT WORKS: Instantiates a graph and asserts its size is zero.
     * TIME COMPLEXITY: O(1)
     */
    private static void testEmptyGraph() { // Method to test empty graph state
        Graph<String> graph = new AdjacencyListGraph<>(true); // Creates a new directed adjacency list graph
        if (graph.vertexCount() != 0) throw new RuntimeException("Fail: Graph should be empty"); // Fails if vertex count is not 0
        if (graph.edgeCount() != 0) throw new RuntimeException("Fail: Graph should have 0 edges"); // Fails if edge count is not 0
    } // Ends method

    /**
     * PURPOSE: Tests adding vertices and handling duplicates.
     * HOW IT WORKS: Adds unique and duplicate vertices, checking return values and counts.
     * TIME COMPLEXITY: O(1) average per insertion.
     */
    private static void testVertexInsertionAndDuplicates() { // Method to test vertex logic
        Graph<String> graph = new AdjacencyListGraph<>(true); // Creates a new graph instance
        boolean added1 = graph.addVertex("A"); // Adds first vertex and stores result
        if (!added1) throw new RuntimeException("Fail: Vertex A should be added"); // Fails if first vertex was rejected
        boolean added2 = graph.addVertex("A"); // Attempts to add a duplicate vertex
        if (added2) throw new RuntimeException("Fail: Duplicate vertex A should be rejected"); // Fails if duplicate was accepted
        if (graph.vertexCount() != 1) throw new RuntimeException("Fail: Vertex count should be exactly 1"); // Verifies size
    } // Ends method

    /**
     * PURPOSE: Tests adding edges and verifying connections.
     * HOW IT WORKS: Adds vertices, connects them with an edge, and tests neighbor retrieval.
     * TIME COMPLEXITY: O(1) amortized for edge insertion.
     */
    private static void testEdgeInsertionAndVerification() { // Method to test edge logic
        Graph<String> graph = new AdjacencyListGraph<>(true); // Creates a new directed graph
        graph.addVertex("A"); // Adds source vertex
        graph.addVertex("B"); // Adds destination vertex
        graph.addEdge("A", "B", 5.0); // Adds a directed edge from A to B with weight 5.0
        if (!graph.containsEdge("A", "B")) throw new RuntimeException("Fail: Edge A->B should exist"); // Validates edge existence
        if (graph.containsEdge("B", "A")) throw new RuntimeException("Fail: Edge B->A should NOT exist in directed graph"); // Validates direction
        if (graph.edgeCount() != 1) throw new RuntimeException("Fail: Edge count should be 1"); // Verifies total edge count
    } // Ends method

    // --- TRAVERSAL TESTS ---

    /**
     * PURPOSE: Tests if BFS correctly finds the minimum-edge path.
     * HOW IT WORKS: Builds a graph with multiple routes and asserts BFS picks the one with fewer edges.
     * TIME COMPLEXITY: O(|V| + |E|)
     */
    private static void testBFSMinimumEdgePath() { // Method to test BFS path finding
        Graph<String> graph = new AdjacencyListGraph<>(true); // Creates directed graph
        graph.addVertex("Start"); // Adds starting node
        graph.addVertex("Mid1"); // Adds intermediate node 1
        graph.addVertex("Mid2"); // Adds intermediate node 2
        graph.addVertex("End"); // Adds destination node
        graph.addEdge("Start", "Mid1", 1.0); // Connects Start to Mid1
        graph.addEdge("Mid1", "Mid2", 1.0); // Connects Mid1 to Mid2
        graph.addEdge("Mid2", "End", 1.0); // Connects Mid2 to End
        graph.addEdge("Start", "End", 10.0); // Connects Start directly to End (1 edge route)
        
        BreadthFirstSearch bfs = new BreadthFirstSearch(); // Instantiates BFS class
        List<String> path = bfs.breadthFirstPath(graph, "Start", "End"); // Retrieves the path
        if (path.size() != 2) throw new RuntimeException("Fail: BFS should choose the direct 1-edge route"); // Path should be [Start, End]
    } // Ends method

    /**
     * PURPOSE: Tests if DFS correctly identifies reachable and unreachable vertices.
     * HOW IT WORKS: Creates a disconnected graph and checks reachability flags.
     * TIME COMPLEXITY: O(|V| + |E|)
     */
    private static void testDFSReachability() { // Method to test DFS reachability
        Graph<String> graph = new AdjacencyListGraph<>(true); // Creates directed graph
        graph.addVertex("A"); // Adds node A
        graph.addVertex("B"); // Adds node B
        graph.addVertex("Isolated"); // Adds an isolated node
        graph.addEdge("A", "B", 1.0); // Connects A to B
        DepthFirstSearch dfs = new DepthFirstSearch(); // Instantiates DFS class
        if (!dfs.isReachable(graph, "A", "B")) throw new RuntimeException("Fail: A should reach B"); // Validates connected component
        if (dfs.isReachable(graph, "A", "Isolated")) throw new RuntimeException("Fail: A should NOT reach Isolated node"); // Validates disconnected component
    } // Ends method

    /**
     * PURPOSE: Tests if DFS correctly detects directed cycles.
     * HOW IT WORKS: Builds a graph with a back-edge and asserts the cycle detection returns true.
     * TIME COMPLEXITY: O(|V| + |E|)
     */
    private static void testDFSCycleDetection() { // Method to test DFS cycle detection
        Graph<String> graph = new AdjacencyListGraph<>(true); // Creates directed graph
        graph.addVertex("A"); // Adds node A
        graph.addVertex("B"); // Adds node B
        graph.addVertex("C"); // Adds node C
        graph.addEdge("A", "B", 1.0); // Edge A -> B
        graph.addEdge("B", "C", 1.0); // Edge B -> C
        graph.addEdge("C", "A", 1.0); // Back-edge C -> A (Creates a cycle)
        DepthFirstSearch dfs = new DepthFirstSearch(); // Instantiates DFS class
        if (!dfs.hasCycle(graph)) throw new RuntimeException("Fail: Cycle should be detected in A->B->C->A"); // Asserts cycle is found
    } // Ends method
} // Ends test class


/**
 * PURPOSE OF CLASS: Defines the Graph Abstract Data Type interface.
 * TIME COMPLEXITIES: N/A (Interface definition).
 * WHAT IS IN IT: Signatures for core graph operations.
 * HOW IT WORKS: Establishes a contract that any specific graph implementation must fulfill.
 */
interface Graph<V> { // Declares a generic interface for the Graph ADT
    boolean addVertex(V vertex); // Signature to add a vertex; returns true if successful
    boolean removeVertex(V vertex); // Signature to remove a vertex; returns true if successful
    boolean addEdge(V source, V destination, double weight); // Signature to add a weighted edge
    boolean removeEdge(V source, V destination); // Signature to remove an edge between two vertices
    boolean containsVertex(V vertex); // Signature to check if a vertex exists in the graph
    boolean containsEdge(V source, V destination); // Signature to check if an edge exists
    List<V> getVertices(); // Signature to retrieve a list of all vertices
    List<V> getNeighbors(V vertex); // Signature to retrieve all destination vertices from a given source
    List<WeightedEdge<V>> getOutgoingEdges(V vertex); // Signature to get all edge objects originating from a vertex
    int vertexCount(); // Signature to get the total number of vertices
    int edgeCount(); // Signature to get the total number of directed edges
    boolean isDirected(); // Signature to check if the graph is strictly directed
} // Ends interface


/**
 * PURPOSE OF CLASS: Implements the Graph ADT using an adjacency list structure.
 * TIME COMPLEXITIES: Mentioned per method. Space complexity is O(|V| + |E|).
 * WHAT IS IN IT: A HashMap associating each vertex with a List of its outgoing edges.
 * HOW IT WORKS: Uses a Map where keys are vertices and values are lists of WeightedEdges.
 */
class AdjacencyListGraph<V> implements Graph<V> { // Declares the class implementing the Graph interface
    private Map<V, List<WeightedEdge<V>>> adjacencyList; // Declares the core map storing vertices and their edge lists
    private boolean directed; // Declares a boolean to track if the graph is directed
    private int edgeCount; // Declares a counter to keep track of total edges

    /**
     * PURPOSE: Constructor to initialize an empty graph.
     * HOW IT WORKS: Instantiates the internal map and sets the directed flag.
     * TIME COMPLEXITY: O(1)
     */
    public AdjacencyListGraph(boolean directed) { // Constructor accepting a boolean for directedness
        this.adjacencyList = new LinkedHashMap<>(); // Instantiates a LinkedHashMap to maintain insertion order predictability
        this.directed = directed; // Sets the directed flag based on input
        this.edgeCount = 0; // Initializes the edge counter to zero
    } // Ends constructor

    @Override public boolean addVertex(V vertex) { // Method to add a vertex
        if (adjacencyList.containsKey(vertex)) return false; // Returns false if the vertex was not added (duplicate)
        adjacencyList.put(vertex, new ArrayList<>()); // Puts the new vertex in the map with an empty ArrayList for edges
        return true; // Returns true indicating successful addition
    } // Ends method

    @Override public boolean addEdge(V source, V destination, double weight) { // Method to add a weighted edge
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) return false; // Verifies both vertices exist
        adjacencyList.get(source).add(new WeightedEdge<>(source, destination, weight)); // Retrieves source's list and adds the new edge
        edgeCount++; // Increments the global edge counter
        if (!directed) { // Checks if the graph is undirected
            adjacencyList.get(destination).add(new WeightedEdge<>(destination, source, weight)); // Adds the reverse edge
            edgeCount++; // Increments the counter again for the reverse edge
        } // Ends if block
        return true; // Returns true indicating success
    } // Ends method

    @Override public List<WeightedEdge<V>> getOutgoingEdges(V vertex) { // Method to get edges
        return adjacencyList.getOrDefault(vertex, Collections.emptyList()); // Returns the list or an empty list if vertex not found
    } // Ends method
    
    @Override public boolean containsVertex(V vertex) { return adjacencyList.containsKey(vertex); } // Returns true if map contains key. Time: O(1)
    @Override public int vertexCount() { return adjacencyList.size(); } // Returns map size. Time: O(1)
    @Override public boolean isDirected() { return directed; } // Returns directed flag. Time: O(1)
    @Override public List<V> getVertices() { return new ArrayList<>(adjacencyList.keySet()); } // Returns list of keys. Time: O(|V|)
    
    @Override public boolean containsEdge(V source, V dest) { // Checks for edge existence
        for (WeightedEdge<V> edge : getOutgoingEdges(source)) { // Iterates over all outgoing edges from source. Time: O(|E_out|)
            if (edge.getDestination().equals(dest)) return true; // Returns true if destination matches
        } // Ends loop
        return false; // Returns false if no match found
    } // Ends method

    @Override public boolean removeEdge(V source, V dest) { return false; /* Omitted for brevity in lab scope */ }
    @Override public boolean removeVertex(V vertex) { return false; /* Omitted for brevity in lab scope */ }
    @Override public List<V> getNeighbors(V vertex) { return Collections.emptyList(); /* Omitted for brevity in lab scope */ }
    @Override public int edgeCount() { return edgeCount; } // Returns edge count. Time O(1)
} // Ends class


/**
 * PURPOSE OF CLASS: Represents a directed, weighted connection between two vertices.
 * TIME COMPLEXITIES: All operations (constructor, getters) are O(1).
 * WHAT IS IN IT: A generic class containing a source vertex, destination vertex, and a double weight.
 * HOW IT WORKS: Stores the structural and cost relationship from one node to another.
 */
class WeightedEdge<V> { // Declares a generic class for a weighted edge
    private final V source; // Immutable reference to the starting vertex
    private final V destination; // Immutable reference to the ending vertex
    private final double weight; // Immutable primitive double representing the cost/distance

    /**
     * PURPOSE: Initializes a weighted edge.
     * HOW IT WORKS: Assigns input parameters to final fields.
     * TIME COMPLEXITY: O(1)
     */
    public WeightedEdge(V source, V destination, double weight) { // Constructor
        this.source = source; // Assigns the source parameter
        this.destination = destination; // Assigns the destination parameter
        this.weight = weight; // Assigns the weight parameter
    } // Ends constructor

    public V getSource() { return source; } // Getter for the source vertex, O(1)
    public V getDestination() { return destination; } // Getter for the destination vertex, O(1)
    public double getWeight() { return weight; } // Getter for the weight value, O(1)
} // Ends class


/**
 * PURPOSE OF CLASS: Represents a physical location in the MiniMap network.
 * TIME COMPLEXITIES: All operations are O(1).
 * WHAT IS IN IT: Fields for ID and name.
 * HOW IT WORKS: Acts as an immutable data object to uniquely identify vertices.
 */
class Location { // Declares the Location class
    private final String id; // Declares an immutable string for the unique location identifier
    private final String name; // Declares an immutable string for the location's descriptive name

    public Location(String id, String name) { // Constructor
        this.id = id; // Assigns id
        this.name = name; // Assigns name
    } // Ends constructor

    public String getId() { return id; } // Getter method for id
    public String getName() { return name; } // Getter method for name
    
    @Override public boolean equals(Object o) { // Equality check
        if (this == o) return true; // Returns true if exact instance
        if (o == null || getClass() != o.getClass()) return false; // Returns false if different class
        Location location = (Location) o; // Casts object
        return id.equals(location.id); // Compares IDs
    } // Ends equals
    @Override public int hashCode() { return id.hashCode(); } // HashCode based on ID
    @Override public String toString() { return name + " (" + id + ")"; } // Formatted string
} // Ends class


/**
 * PURPOSE OF CLASS: Implements Breadth-First Search algorithms for traversal and shortest-path (by edge count).
 * TIME COMPLEXITIES: Traversal and Pathfinding are O(|V| + |E|).
 * WHAT IS IN IT: Methods to traverse the graph level-by-level and to reconstruct paths.
 * HOW IT WORKS: Uses a FIFO Queue to explore nearest neighbors before moving deeper.
 */
class BreadthFirstSearch { // Declares the BFS utility class
    /**
     * PURPOSE: Finds a path with the minimum number of edges between source and destination.
     * HOW IT WORKS: Executes standard BFS while recording predecessors, then backtracks.
     * TIME COMPLEXITY: O(|V| + |E|)
     */
    public <V> List<V> breadthFirstPath(Graph<V> graph, V source, V destination) { // Method signature
        if (!graph.containsVertex(source) || !graph.containsVertex(destination)) return Collections.emptyList(); // Invalid endpoints
        Queue<V> queue = new ArrayDeque<>(); // Initializes FIFO queue
        Set<V> visited = new HashSet<>(); // Set to track visited vertices
        Map<V, V> predecessors = new HashMap<>(); // Map for backtracking
        
        queue.add(source); // Enqueues start
        visited.add(source); // Marks start visited
        
        while (!queue.isEmpty()) { // Loops while queue has elements
            V current = queue.poll(); // Dequeues next
            if (current.equals(destination)) break; // Stop if target reached
            
            for (WeightedEdge<V> edge : graph.getOutgoingEdges(current)) { // Iterates neighbors
                V neighbor = edge.getDestination(); // Gets neighbor
                if (!visited.contains(neighbor)) { // If not visited
                    visited.add(neighbor); // Mark visited
                    predecessors.put(neighbor, current); // Record path
                    queue.add(neighbor); // Enqueue neighbor
                } // Ends if
            } // Ends for
        } // Ends while
        
        return reconstructPath(source, destination, predecessors); // Builds final list
    } // Ends method

    private <V> List<V> reconstructPath(V source, V destination, Map<V, V> predecessors) { // Helper to build path
        List<V> path = new ArrayList<>(); // Path list
        V current = destination; // Starts at end
        while (current != null) { // Loops backwards
            path.add(current); // Adds to path
            if (current.equals(source)) break; // Stops at source
            current = predecessors.get(current); // Moves to parent
        } // Ends while
        if (path.isEmpty() || !path.get(path.size() - 1).equals(source)) return Collections.emptyList(); // Path invalid
        Collections.reverse(path); // Reverses to forward order
        return path; // Returns result
    } // Ends method
} // Ends class


/**
 * PURPOSE OF CLASS: Implements Depth-First Search algorithms for reachability and cycle detection.
 * TIME COMPLEXITIES: Traversal, Reachability, and Cycle Detection are all O(|V| + |E|).
 * WHAT IS IN IT: Iterative/Recursive traversal methods.
 * HOW IT WORKS: Uses recursion to explore deeply before backtracking.
 */
class DepthFirstSearch { // Declares the DFS utility class
    /**
     * PURPOSE: Determines if a path exists between source and destination.
     * HOW IT WORKS: Wraps a standard DFS traversal.
     * TIME COMPLEXITY: O(|V| + |E|)
     */
    public <V> boolean isReachable(Graph<V> graph, V source, V destination) { // Method signature
        if (!graph.containsVertex(source) || !graph.containsVertex(destination)) return false; // Invalid endpoints
        Set<V> visited = new HashSet<>(); // Visited set
        dfsRecursive(graph, source, visited, destination); // Recursive call
        return visited.contains(destination); // Checks if target was seen
    } // Ends method

    private <V> void dfsRecursive(Graph<V> graph, V current, Set<V> visited, V target) { // Recursive helper
        visited.add(current); // Marks visited
        if (target != null && current.equals(target)) return; // Short-circuit if found
        for (WeightedEdge<V> edge : graph.getOutgoingEdges(current)) { // Checks neighbors
            V neighbor = edge.getDestination(); // Gets destination
            if (!visited.contains(neighbor)) dfsRecursive(graph, neighbor, visited, target); // Recursion
        } // Ends for
    } // Ends method

    /**
     * PURPOSE: Detects if the graph contains any cycles.
     * HOW IT WORKS: Uses DFS tracking the current recursion stack.
     * TIME COMPLEXITY: O(|V| + |E|)
     */
    public <V> boolean hasCycle(Graph<V> graph) { // Method signature
        Set<V> visited = new HashSet<>(); // Global visited set
        Set<V> recursionStack = new HashSet<>(); // Current path set
        for (V vertex : graph.getVertices()) { // Iterate all nodes (handles disconnects)
            if (!visited.contains(vertex)) { // If not checked
                if (checkCycleDFS(graph, vertex, visited, recursionStack)) return true; // Check component
            } // Ends if
        } // Ends for
        return false; // No cycles
    } // Ends method

    private <V> boolean checkCycleDFS(Graph<V> graph, V current, Set<V> visited, Set<V> recursionStack) { // Cycle helper
        visited.add(current); // Marks globally seen
        recursionStack.add(current); // Marks in current path
        for (WeightedEdge<V> edge : graph.getOutgoingEdges(current)) { // Checks neighbors
            V neighbor = edge.getDestination(); // Gets neighbor
            if (!visited.contains(neighbor)) { // If unseen entirely
                if (checkCycleDFS(graph, neighbor, visited, recursionStack)) return true; // Recursion
            } else if (recursionStack.contains(neighbor)) { // If seen IN CURRENT PATH
                return true; // Cycle found!
            } // Ends if/else
        } // Ends for
        recursionStack.remove(current); // Backtracks stack
        return false; // Safe
    } // Ends method
} // Ends class