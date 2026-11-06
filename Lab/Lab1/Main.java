

public class Main {
    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println("       CSI 2110 Lab 1 - Comprehensive Test Suite    ");
        System.out.println("=====================================================");

        // 1. Array Execution Flow
        System.out.println("\n--- Testing ArrayIntegerSequence (Part A) ---");
        ArrayIntegerSequence arraySeq = new ArrayIntegerSequence();
        arraySeq.addLast(10);
        arraySeq.addLast(20);
        arraySeq.addFirst(5);
        System.out.print("Expected Sequence [5 10 20]: ");
        arraySeq.printSequence();
        System.out.println("Contains 10? " + arraySeq.contains(10));
        System.out.println("Removed Item: " + arraySeq.removeFirst());
        System.out.print("Sequence after removal: ");
        arraySeq.printSequence();

        // 2. Singly Linked List & Recursion Flow
        System.out.println("\n--- Testing LinkedIntegerSequence & Recursion (Parts B & D) ---");
        LinkedIntegerSequence linkedSeq = new LinkedIntegerSequence();
        linkedSeq.addLast(4);
        linkedSeq.addLast(7);
        linkedSeq.addLast(2);
        linkedSeq.addLast(9);
        System.out.print("Sequence: ");
        linkedSeq.printSequence();
        System.out.println("Recursive Sum (Expected 22): " + linkedSeq.recursiveSum());
        System.out.println("Recursive Max (Expected 9): " + linkedSeq.recursiveMax());
        System.out.print("Recursive Print Reverse (Expected 9 2 7 4): ");
        linkedSeq.recursivePrintReverse();

        // 3. Circular & Doubly Mini Exercises
        System.out.println("\n--- Testing Linked Mini-Exercises (Part C) ---");
        CircularIntegerList circList = new CircularIntegerList();
        circList.addLast(100);
        circList.addLast(200);
        circList.addLast(300);
        System.out.print("Circular List Before Rotation: ");
        circList.printList();
        circList.rotate();
        System.out.print("Circular List After One Rotation: ");
        circList.printList();

        DoublyIntegerList doubleList = new DoublyIntegerList();
        doubleList.addFirst(10);
        doubleList.addLast(20);
        System.out.print("Doubly Linked List Content: ");
        doubleList.printList();

        // 4. Extra Exercises & Copying
        Lab1Utilities.runPartEExercises();

        System.out.println("\n--- Testing Equivalence & Deep Cloning (Part F) ---");
        ArrayIntegerSequence original = new ArrayIntegerSequence();
        original.addLast(50);
        original.addLast(60);
        ArrayIntegerSequence clone = Lab1Utilities.deepCopy(original);
        System.out.println("Original & Clone equivalent? " + Lab1Utilities.areEquivalent(original, clone));
        original.addLast(70);
        System.out.println("After modifying original, are they still equivalent? " + Lab1Utilities.areEquivalent(original, clone));

        // 5. Edge Case Assertions
        System.out.println("\n--- Testing Specific Boundary Edge Cases ---");
        ArrayIntegerSequence emptyTestSeq = new ArrayIntegerSequence();
        System.out.println("Is sequence empty? " + emptyTestSeq.isEmpty());
        
        try {
            emptyTestSeq.removeFirst();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception on empty removal: " + e.getMessage());
        }

        try {
            arraySeq.get(15);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception on out-of-bounds index lookup: " + e.getMessage());
        }

        ArrayIntegerSequence singleElementSeq = new ArrayIntegerSequence();
        singleElementSeq.addFirst(99);
        System.out.print("Single-element sequence validation: ");
        singleElementSeq.printSequence();
        System.out.println("Single-element lookup index 0: " + singleElementSeq.get(0));
    }
}