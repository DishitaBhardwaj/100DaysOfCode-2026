class Solution {
    public int kthSmallest(int[] A, int[] B, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        int ans = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                ans = A[i];
                i++;
            } else {
                ans = B[j];
                j++;
            }
            count++;
            if (count == k) {
                return ans;
            }
        }
        while (i < A.length) {
            ans = A[i];
            i++;
            count++;
            if (count == k) {
                return ans;
            }
        }
        while (j < B.length) {
            ans = B[j];
            j++;
            count++;
            if (count == k) {
                return ans;
            }
        }
        return -1;
    }
}