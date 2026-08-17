class Solution {
    public int kthSmallest(int[] A, int[] B, int k) {
        // Ensure A is the smaller array for efficient binary search
        if (A.length > B.length) return kthSmallest(B, A, k);
        
        int n = A.length, m = B.length;
        int low = Math.max(0, k - m), high = Math.min(k, n);
        
        while (low <= high) {
            int i = (low + high) / 2; // elements taken from A
            int j = k - i;            // elements taken from B
            
            // Boundary-safe values
            int Aleft  = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == n) ? Integer.MAX_VALUE : A[i];
            int Bleft  = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == m) ? Integer.MAX_VALUE : B[j];
            
            if (Aleft <= Bright && Bleft <= Aright) {
                // Valid partition found; kth smallest is the max of left elements
                return Math.max(Aleft, Bleft);
            } else if (Aleft > Bright) {
                high = i - 1; // too many elements taken from A, shrink
            } else {
                low = i + 1;  // too few elements taken from A, expand
            }
        }
        
        throw new IllegalArgumentException("Invalid input arrays or k");
    }
}
