<h2 align="center">Week 7 Day 47 (31/07/2026)</h2>

## 1. Relative Ranks

### Solution

```cpp
#include <vector>
#include <string>
#include <algorithm>
#include <numeric>
using namespace std;

class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        int n = score.size();
        vector<int> idx(n);
        iota(idx.begin(), idx.end(), 0);

        // Sort indices by score descending
        sort(idx.begin(), idx.end(), [&](int a, int b) {
            return score[a] > score[b];
        });

        vector<string> answer(n);
        for (int rank = 0; rank < n; rank++) {
            int athlete = idx[rank];
            if (rank == 0) answer[athlete] = "Gold Medal";
            else if (rank == 1) answer[athlete] = "Silver Medal";
            else if (rank == 2) answer[athlete] = "Bronze Medal";
            else answer[athlete] = to_string(rank + 1);
        }
        return answer;
    }
};
```

Approach: sort indices by score value (descending), then walk through in that order assigning medals/ranks. This avoids sorting the scores directly, so we still know which original position (athlete) each rank belongs to.

Complexity: O(n log n) time, O(n) space.

---

## 2. K-th Smallest Element in Two Sorted Arrays

### Solution

```cpp
#include <vector>
#include <climits>
using namespace std;

class Solution {
public:
    int findKthSmallest(vector<int>& A, vector<int>& B, int k) {
        // Ensure A is the smaller array for efficient binary search
        if (A.size() > B.size()) return findKthSmallest(B, A, k);

        int n = A.size(), m = B.size();
        int low = max(0, k - m), high = min(k, n);

        while (low <= high) {
            int cutA = (low + high) / 2;
            int cutB = k - cutA;

            int leftA  = (cutA == 0) ? INT_MIN : A[cutA - 1];
            int leftB  = (cutB == 0) ? INT_MIN : B[cutB - 1];
            int rightA = (cutA == n) ? INT_MAX : A[cutA];
            int rightB = (cutB == m) ? INT_MAX : B[cutB];

            if (leftA <= rightB && leftB <= rightA) {
                // The k-th smallest is the max of the two "left" parts
                return max(leftA, leftB);
            } else if (leftA > rightB) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }
        return -1; // shouldn't reach here given valid constraints
    }
};
```

Approach (binary search / partition method): we binary search on how many elements to take from array `A` (`cutA`), which determines how many to take from `B` (`cutB = k - cutA`), such that the combined left partition has exactly `k` elements and every element on the left is ≤ every element on the right. When that partition condition holds (`leftA <= rightB` and `leftB <= rightA`), the k-th smallest is `max(leftA, leftB)`.

Complexity: O(log(min(n, m))) time, O(1) extra space — much faster than merging (O(n+m)).
