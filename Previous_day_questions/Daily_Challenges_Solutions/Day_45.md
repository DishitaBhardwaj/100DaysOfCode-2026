<h2 align="center">Week 7 Day 45 (29/07/2026)</h2>

## 1. Search Insert Position

### Solution

```java
class Solution {
    public int searchInsert(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            if (nums[m] == t) {
                return m;
            } else if (nums[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 7)); // 4
    }
}
```

Standard binary search: if the target is found, return its index. Otherwise, when the loop ends, `l` has converged to exactly the position where the target would be inserted to keep the array sorted.

Complexity: O(log n) time, O(1) extra space.

---

## 2. Count Inversions in an Array

### Solution

```java
class Solution {
    public long countInv(int[] a) {
        int[] tmp = new int[a.length];
        return sort(a, tmp, 0, a.length - 1);
    }
    
    private long sort(int[] a, int[] tmp, int l, int r) {
        long cnt = 0;
        
        if (l < r) {
            int m = l + (r - l) / 2;
            
            cnt += sort(a, tmp, l, m);
            cnt += sort(a, tmp, m + 1, r);
            cnt += merge(a, tmp, l, m, r);
        }
        
        return cnt;
    }
    
    private long merge(int[] a, int[] tmp, int l, int m, int r) {
        int i = l, j = m + 1, k = l;
        long cnt = 0;
        
        while (i <= m && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
                cnt += (m - i + 1);
            }
        }
        
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        
        for (i = l; i <= r; i++) a[i] = tmp[i];
        
        return cnt;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countInv(new int[]{2, 4, 1, 3, 5})); // 3
        System.out.println(s.countInv(new int[]{5, 4, 3, 2, 1})); // 10
        System.out.println(s.countInv(new int[]{1, 2, 3, 4, 5})); // 0
    }
}
```

Standard merge-sort-based inversion count: while merging two sorted halves, whenever an element from the right half (`a[j]`) is placed before a remaining element from the left half (`a[i]`), it means `a[i]` and everything after it up to `m` forms an inversion with `a[j]` — that's `(m - i + 1)` inversions counted in one step, instead of comparing pairs individually.

Complexity: O(n log n) time, O(n) extra space.
