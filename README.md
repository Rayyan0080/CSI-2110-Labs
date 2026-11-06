# CSI 2110 Data Structures and Algorithms

This repository contains Java implementations and lab exercises for CSI 2110: Data Structures and Algorithms, based on the Spring/Summer 2026 course syllabus.

## Course overview

- Course: CSI 2110 Data Structures and Algorithms
- Term: Spring/Summer 2026
- Professor: Mohamed Ali Ibrahim, Ph.D., P.Eng.
- Focus areas: abstract data types, complexity analysis, trees, sorting, graphs, strings, and pattern matching.

## Repository structure

```text
CSI-2110/
├── Lab/
│   ├── Lab1/
│   ├── Lab2/
│   ├── lab3/
│   ├── lab4/
│   └── lab5/
├── README.md
├── .gitignore
└── CSI2110_Syllabus_SpringSummer_2026.pdf
```

## Lab breakdown

### Lab 1: Sequence ADTs and linked list fundamentals

This lab focuses on understanding abstract data types built around integer sequences and list structures. It introduces array-based and linked-list implementations, recursion, and core operations such as insertion, deletion, traversal, lookup, and comparison.

Key concepts included:
- Array-based sequence behavior
- Singly linked list operations
- Circular list rotation
- Doubly linked list operations
- Recursive algorithms for sum, maximum, and reverse printing
- Deep-copy and equivalence checks for data structures
- Edge-case validation and exception handling

Relevant implementation files:
- `Lab/Lab1/ArrayIntegerSequence.java`
- `Lab/Lab1/LinkedIntegerSequence.java`
- `Lab/Lab1/CircularIntegerList.java`
- `Lab/Lab1/DoublyIntegerList.java`
- `Lab/Lab1/Lab1Utilities.java`
- `Lab/Lab1/Main.java`

### Lab 2: Linear data structures and ticket processing system

This lab applies stacks, queues, deques, and list structures to a simplified ticket-processing system. The goal is to understand how ADTs behave in real-world situations and to compare array-backed and linked implementations.

Key concepts included:
- Stack ADT and stack applications
- Queue ADT and circular-array queue behavior
- Deque operations from both ends
- Dynamic-array list implementation
- Positional list / iterator concepts
- Ticket processing, undo actions, and queue-based service simulation
- Complexity analysis and design trade-offs

Relevant implementation files:
- `Lab/Lab2/Stack.java`
- `Lab/Lab2/ArrayStack.java`
- `Lab/Lab2/Queue.java`
- `Lab/Lab2/CircularArrayQueue.java`
- `Lab/Lab2/Ticket.java`

### Lab 3: Priority queues and heaps

This lab introduces priority queues as an ADT and demonstrates how heaps provide efficient insert and remove-min operations. The implementation is designed around the idea that the smallest priority item is always available at the root of a min-heap.

Key concepts included:
- Priority queue behavior
- Heap structure and heap-order property
- Insert and remove-min complexity
- Min-heap representation in arrays
- Task-based data objects with priorities
- Efficiency comparisons against unsorted list implementations

Relevant implementation files:
- `Lab/lab3/HeapPriorityQueue.java`
- `Lab/lab3/ListPriorityQueue.java`
- `Lab/lab3/PriorityQueue.java`
- `Lab/lab3/Task.java`
- `Lab/lab3/Entry.java`
- `Lab/lab3/MainTester.java`

### Lab 4: Sorting algorithms and string pattern matching

This lab focuses on sorting strategies and the divide-and-conquer pattern. It compares simple sorting with efficient algorithms and also introduces brute-force pattern matching in text.

Key concepts included:
- Insertion sort as a baseline algorithm
- Merge-sort and divide-and-conquer design
- Quick-sort and pivot selection
- Heap-sort and heap-based sorting
- Algorithm comparison across best, average, and worst cases
- Stability and in-place sorting analysis
- String searching and pattern occurrence counting

Relevant implementation files:
- `Lab/lab4/SimpleSort.java`
- `Lab/lab4/MergeSort.java`
- `Lab/lab4/StudentRecord.java`

### Lab 5: Graphs, traversals, and shortest paths

This lab focuses on graph theory and route-planning logic. It models locations as vertices and roads as weighted edges, then implements graph algorithms for traversal, reachability checking, and shortest path computation.

Key concepts included:
- Graph ADT design
- Adjacency-list graph representation
- Breadth-first search (BFS)
- Depth-first search (DFS)
- Reachability and cycle detection
- Minimum-edge path analysis
- Weighted graphs and distance-aware navigation
- Dijkstra's algorithm and Bellman-Ford concepts
- Path reconstruction and graph validation

Relevant implementation files:
- `Lab/lab5/Graph.java`
- `Lab/lab5/AdjacencyListGraph.java`
- `Lab/lab5/BreadthFirstSearch.java`
- `Lab/lab5/DepthFirstSearch.java`
- `Lab/lab5/WeightedEdge.java`
- `Lab/lab5/Location.java`
- `Lab/lab5/GraphApp.java`

## Course themes covered across the labs

This project reflects the main CSI 2110 syllabus topics:
- ADTs and data structure design
- Complexity analysis and Big-O reasoning
- linear structures: stacks, queues, deques, and lists
- trees and priority queues
- sorting and selection algorithms
- graph representations and traversal techniques
- shortest-path reasoning and algorithmic efficiency
- string processing and pattern matching

## Notes

- The code is written in Java and is intended for learning and practice.
- The repository is structured around the official lab sequence from the course syllabus.
- The lab folders contain the practical implementations and test programs used during the course.
