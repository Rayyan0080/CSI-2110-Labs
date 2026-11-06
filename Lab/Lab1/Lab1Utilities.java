
import java.util.Arrays;
import java.util.Random;

public class Lab1Utilities {

    // ==========================================
    // PART E: EXTRA ARRAYS EXERCISES
    // ==========================================
    public static void runPartEExercises() {
        System.out.println("\n--- Part E: Array Exercises Execution ---");
        
        // 1 & 2. Storing & Sorting a Copy
        int[] scores = {88, 45, 92, 71, 63, 99, 82, 75, 91, 79};
        System.out.println("Stored Scores: " + Arrays.toString(scores));
        int[] sortedCopy = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedCopy);
        System.out.println("Sorted Copy:   " + Arrays.toString(sortedCopy));

        // 3. java.util.Random processing
        Random rand = new Random();
        int[] generated = new int[5];
        for (int i = 0; i < generated.length; i++) {
            generated[i] = rand.nextInt(100);
        }
        System.out.println("Random Values: " + Arrays.toString(generated));

        // 4. Character Array Palindrome Test
        char[] radar = {'r', 'a', 'd', 'a', 'r'};
        System.out.println("Is 'radar' Palindrome? " + checkPalindrome(radar));

        // 5. 2D Array Matrix Analysis
        int[][] board = {{1, 2}, {3, 4}};
        System.out.println("2D Matrix Sum Calculations:");
        for (int i = 0; i < board.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < board[i].length; j++) rowSum += board[i][j];
            System.out.println("  Row " + i + " Sum: " + rowSum);
        }
    }

    private static boolean checkPalindrome(char[] word) {
        int left = 0, right = word.length - 1;
        while (left < right) {
            if (word[left++] != word[right--]) return false;
        }
        return true;
    }

    // ==========================================
    // PART F: EQUIVALENCE & DEEP CLONING
    // ==========================================
    public static boolean areEquivalent(IntegerSequence s1, IntegerSequence s2) {
        if (s1.size() != s2.size()) return false;
        for (int i = 0; i < s1.size(); i++) {
            if (s1.get(i) != s2.get(i)) return false;
        }
        return true;
    }

    public static ArrayIntegerSequence deepCopy(ArrayIntegerSequence original) {
        ArrayIntegerSequence copy = new ArrayIntegerSequence();
        for (int i = 0; i < original.size(); i++) {
            copy.addLast(original.get(i));
        }
        return copy;
    }
}