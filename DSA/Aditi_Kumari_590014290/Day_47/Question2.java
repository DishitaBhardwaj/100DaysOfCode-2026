/*K-th Smallest Element in Two Sorted Arrays
Explanation
Write an efficient function to find the k-th smallest element across two sorted arrays without merging them.

Example
Input: A = [2, 3, 6, 7], B = [1, 4, 5, 8], k = 5. Output: 5. */
package Day_47;

public class Question2 {
    public int smallest(int[] A, int[] B, int k){
        int i=0,j=0,count=0;
        while(i<A.length && j< B.length){
            if (A[i] < B[j]){
                count++;
                if (count == k){
                    return A[i];
                }
                i++;
            }
                else{
                    count++;
                    if (count == k){
                        return B[j];
                    }
                    j++;
            }          
        }
        while (i < A.length){
            count ++;
            if (count == k){
                return A[i];
            }
            i++;
        }
        while (j< B.length){
            count ++;
            if (count == k){
                return B[j];
            }
            j++;
        }
        return -1;
    }
}
