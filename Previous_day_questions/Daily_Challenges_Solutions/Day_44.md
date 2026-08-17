<h2 align="center">Week 7 Day 44 (28/07/2026)</h2>

## 1. Can Make Arithmetic Progression From Sequence

### Solution

Approach: sort the array, then check if the difference between every pair of consecutive elements is the same.

```cpp
#include <bits/stdc++.h>
using namespace std;

bool canMakeArithmeticProgression(vector<int>& arr) {
    sort(arr.begin(), arr.end());
    int diff = arr[1] - arr[0];
    for (int i = 2; i < arr.size(); i++) {
        if (arr[i] - arr[i - 1] != diff) return false;
    }
    return true;
}

int main() {
    vector<int> arr1 = {3, 5, 1};
    cout << (canMakeArithmeticProgression(arr1) ? "true" : "false") << endl; // true

    vector<int> arr2 = {1, 2, 4};
    cout << (canMakeArithmeticProgression(arr2) ? "true" : "false") << endl; // false

    return 0;
}
```

Complexity: O(n log n) time, O(1) extra space (ignoring sort).

---

## 2. Favourite Number

### Solution

Key idea: after sorting descending, the first `k` elements get removed. Let `val` be the favorite element's value.

* `cnt_greater` = number of elements strictly greater than `val` (they will always end up before the favorite, regardless of tie-breaking).
* `cnt_equal` = number of elements equal to `val` (their relative order among themselves — including the favorite — can vary).

The favorite element's possible rank (1-indexed) after sorting ranges from:

* Best case: `cnt_greater + 1` (favorite placed first among the equal block)
* Worst case: `cnt_greater + cnt_equal` (favorite placed last among the equal block)

So:

* If even the worst case rank `<= k` → it's always removed → `"YES"`
* If even the best case rank `> k` (i.e. `cnt_greater >= k`) → it's never removed → `"NO"`
* Otherwise → `"MAYBE"`

```cpp
#include <bits/stdc++.h>
using namespace std;

string favouriteNumber(vector<int>& nums, int favoriteIndex, int k) {
    int val = nums[favoriteIndex - 1]; // convert to 0-indexed
    int cntGreater = 0, cntEqual = 0;

    for (int x : nums) {
        if (x > val) cntGreater++;
        else if (x == val) cntEqual++;
    }

    if (cntGreater + cntEqual <= k) return "YES";   // definitely removed
    if (cntGreater >= k) return "NO";                // definitely not removed
    return "MAYBE";                                  // depends on tie-breaking
}

int main() {
    vector<int> nums1 = {4, 3, 3, 2, 3};
    cout << favouriteNumber(nums1, 2, 2) << endl; // MAYBE

    vector<int> nums2 = {4, 2, 1, 3, 5};
    cout << favouriteNumber(nums2, 5, 3) << endl; // YES

    vector<int> nums3 = {5, 2, 4, 1, 3};
    cout << favouriteNumber(nums3, 5, 2) << endl; // NO

    return 0;
}
```

Complexity: O(n) time, O(1) extra space.

### Quick trace of Sample 1

`nums = [4,3,3,2,3]`, `favoriteIndex=2` → `val = 3`

* `cntGreater` (elements > 3) = 1 (`4`)
* `cntEqual` (elements == 3) = 3
* `cntGreater >= k` → `1 >= 2`? No
* `cntGreater + cntEqual <= k` → `4 <= 2`? No
* → `"MAYBE"` ✅ (matches expected output)

Both solutions handle all edge cases within the given constraints and run well within time limits for `n <= 1000`.
