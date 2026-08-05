<h2 align="center">Week 8 Day 51 (04/08/2026)</h2>

## 1. Most Frequent Even Element (LeetCode #2404)

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int mostFrequentEven(vector<int>& nums) {
    unordered_map<int, int> freq;
    for (int x : nums) {
        if (x % 2 == 0) freq[x]++;
    }

    int best = -1, bestCount = 0;
    for (auto& [val, cnt] : freq) {
        if (cnt > bestCount || (cnt == bestCount && val < best)) {
            best = val;
            bestCount = cnt;
        }
    }
    return best;
}

int main() {
    vector<int> n1 = {0,1,2,2,4,4,1};
    cout << mostFrequentEven(n1) << endl; // 2

    vector<int> n2 = {4,4,4,9,2,4};
    cout << mostFrequentEven(n2) << endl; // 4

    vector<int> n3 = {29,47,21,41,13,37,25,7};
    cout << mostFrequentEven(n3) << endl; // -1

    return 0;
}
```

How it works: count occurrences of every even number in a hash map, ignoring odd elements entirely. Then scan the map once, keeping track of the best `(count, value)` seen so far — a candidate replaces the current best if it has a strictly higher count, or the same count with a smaller value (tie-break rule). If no even element was ever inserted, `best` stays `-1`.

Complexity: O(n) time, O(n) extra space for the frequency map.

---

## 2. Receiving Log Validation

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int firstInvalidRecord(vector<vector<string>>& deliveries) {
    // key: vendor_id + "#" + lot_number -> cert_code seen so far
    unordered_map<string, string> seen;

    for (int i = 0; i < (int)deliveries.size(); i++) {
        const string& vendor = deliveries[i][0];
        const string& lot    = deliveries[i][1];
        const string& cert   = deliveries[i][2];

        string key = vendor + "#" + lot;
        auto it = seen.find(key);

        if (it == seen.end()) {
            seen[key] = cert;
        } else if (it->second != cert) {
            return i;
        }
    }
    return -1;
}

int main() {
    vector<vector<string>> d1 = {
        {"V1","L100","A"}, {"V2","L200","B"}, {"V1","L100","A"}, {"V1","L100","C"}
    };
    cout << firstInvalidRecord(d1) << endl; // 3

    vector<vector<string>> d2 = {
        {"V1","L100","A"}, {"V1","L101","A"}, {"V2","L100","A"}
    };
    cout << firstInvalidRecord(d2) << endl; // -1

    vector<vector<string>> d3 = {
        {"V3","L500","X"}, {"V3","L500","Y"}
    };
    cout << firstInvalidRecord(d3) << endl; // 1

    return 0;
}
```

How it works: process the records in order, using a hash map keyed on `vendor_id + "#" + lot_number` (a delimiter avoids accidental key collisions like `"V1"+"L23"` vs `"V1L"+"2"`). The first time a `(vendor, lot)` pair is seen, its cert code is recorded. On any later occurrence of the same pair, if the cert code doesn't match what's stored, that record's index is immediately returned as invalid. If the loop finishes without a mismatch, return `-1`.

Complexity: O(n · L) time, where `n` is the number of deliveries and `L` bounds the string lengths (≤ 20) involved in hashing/comparison — effectively O(n) for the given constraints. O(n · L) extra space for the map.
