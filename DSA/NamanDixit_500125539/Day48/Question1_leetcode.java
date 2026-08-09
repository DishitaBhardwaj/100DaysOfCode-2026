
class Question1_leetcode {

    // Function to sort the rows of 'score' matrix by the k-th column, descending
    public int[][] sortTheStudents(int[][] score, int k) {

        // Sort rows using a custom comparator: compare the k-th column
        // of each row, in DESCENDING order.
        Arrays.sort(score, (rowA, rowB) -> rowB[k] - rowA[k]);

        return score;
    }
}
