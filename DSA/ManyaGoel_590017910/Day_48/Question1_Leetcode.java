// Approach 1: Using Arrays.sort() with Comparator ,Time Complexity: O(n log n), Space Complexity: O(n)

public class Question1_Leetcode {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }
}

// Approach 2: Using Heap Sort
// Time Complexity: O(n log n), Space Complexity: O(log n)

public class Question1_Leetcode {
    public int[][] sortTheStudents(int[][] score, int k) {
        int n = score.length;
        // Build min heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(score, n, i, k);
        }
        // Move minimum elements to the end
        for (int i = n - 1; i > 0; i--) {
            swap(score, 0, i);
            heapify(score, i, 0, k);
        }
        return score;
    }

    private void heapify(int[][] score, int n, int i, int k) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && score[left][k] < score[smallest][k]) smallest = left;
        if (right < n && score[right][k] < score[smallest][k]) smallest = right;
        if (smallest != i) {
            swap(score, i, smallest);
            heapify(score, n, smallest, k);
        }
    }
    private void swap(int[][] score, int i, int j) {
        int[] temp = score[i];
        score[i] = score[j];
        score[j] = temp;
    }
}