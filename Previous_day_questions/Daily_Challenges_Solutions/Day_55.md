<h2 align="center">Week 8 Day 55 (08/08/2026)</h2>

## 1. Find Subsequence of Length K With the Largest Sum (LeetCode #2099)

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

vector<int> maxSubsequence(vector<int>& nums, int k) {
    int n = nums.size();
    vector<int> idx(n);
    iota(idx.begin(), idx.end(), 0);

    // Stable sort indices by value descending (ties keep original order)
    stable_sort(idx.begin(), idx.end(), [&](int a, int b) {
        return nums[a] > nums[b];
    });

    vector<int> chosen(idx.begin(), idx.begin() + k);
    sort(chosen.begin(), chosen.end()); // restore original relative order

    vector<int> result;
    for (int i : chosen) result.push_back(nums[i]);
    return result;
}

void printVec(const vector<int>& v) {
    cout << "[";
    for (size_t i = 0; i < v.size(); i++) {
        cout << v[i] << (i + 1 == v.size() ? "" : ",");
    }
    cout << "]\n";
}

int main() {
    vector<int> n1 = {2,1,3,3};
    printVec(maxSubsequence(n1, 2)); // [3,3]

    vector<int> n2 = {-1,-2,3,4};
    printVec(maxSubsequence(n2, 3)); // [-1,3,4]

    vector<int> n3 = {3,4,3,3};
    printVec(maxSubsequence(n3, 2)); // [3,4]

    return 0;
}
```

How it works: to maximize the sum of a length-`k` subsequence, we simply need the `k` largest values — order doesn't affect the sum. So indices are stable-sorted by value descending (ties preserve original order), the top `k` indices are taken, and then those indices are sorted back into ascending order so the chosen values are emitted in their original relative order, which is required for a valid subsequence.

Complexity: O(n log n) time (two sorts), O(n) extra space.

---

## 2. Maximum Playlist Pleasure

### Solution

This is the classic "sort by one dimension, sweep with a min-heap on the other" pattern (the same idea behind LeetCode's Maximum Performance of a Team). Sort songs by beauty descending, and process them one at a time as the "current minimum beauty." Maintain a min-heap of the lengths of at most `k` selected songs so far — whenever the heap would exceed size `k`, evict the smallest length, since it contributes least to the sum.

```cpp
#include <bits/stdc++.h>
using namespace std;

long long maxPleasure(vector<int>& length, vector<int>& beauty, int k) {
    int n = length.size();
    vector<int> idx(n);
    iota(idx.begin(), idx.end(), 0);

    // Process songs in decreasing order of beauty
    sort(idx.begin(), idx.end(), [&](int a, int b) {
        return beauty[a] > beauty[b];
    });

    priority_queue<int, vector<int>, greater<int>> minHeap; // smallest length on top
    long long sumLen = 0, best = 0;

    for (int i : idx) {
        int len = length[i];
        int bty = beauty[i];

        minHeap.push(len);
        sumLen += len;

        if ((int)minHeap.size() > k) {
            sumLen -= minHeap.top();
            minHeap.pop();
        }

        // Current song has the smallest beauty among all selected so far
        best = max(best, sumLen * (long long)bty);
    }

    return best;
}

int main() {
    vector<int> len1 = {4, 15, 3, 6};
    vector<int> b1   = {7, 1, 6, 8};
    cout << maxPleasure(len1, b1, 3) << endl; // 78

    vector<int> len2 = {12, 112, 100, 13, 55};
    vector<int> b2   = {31, 4, 100, 55, 50};
    cout << maxPleasure(len2, b2, 3) << endl; // 10000

    return 0;
}
```

How it works: since songs are processed in decreasing beauty order, whichever song is being processed right now is guaranteed to have the smallest beauty among every song added to the heap so far — so `sumLen * beauty[current]` is a valid candidate pleasure value at every step. Keeping the heap capped at size `k` and always evicting the smallest length when it overflows ensures `sumLen` reflects the best possible sum of up to `k` lengths paired with that minimum beauty. Taking the max over all steps covers every possible choice of "which song sets the minimum."

Complexity: O(n log n) time (sorting plus n heap operations), O(n) extra space — comfortably handles `n ≤ 300,000`.
