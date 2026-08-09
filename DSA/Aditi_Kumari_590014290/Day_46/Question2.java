/*Part B: Custom ACM DSA Problem
Maximum Prefix Difference Score
Explanation
Write an efficient function to rearrange an array to maximize the sum of (running max − running min) across all prefixes.

Example
Input: [7, 6, 5]. Output: 4. */
package Day_46;
public class Question2 {
    public int MaxPrefix(int[] arr){
        int n=arr.length;
        int max=arr[0];
        int min= arr[0];
        for(int  i=1; i<n;i++){
            max=Math.max(max, arr[i]);
            min=Math.min(min,arr[i]);
        }
        int ans=(max-min)*(n-1);
        return ans;

    }
}
