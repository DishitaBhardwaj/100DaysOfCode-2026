#include <bits/stdc++.h>
using namespace std;

long long maximumPrefixDifferenceScore(vector<int>& nums) {
    int n = nums.size();

    if (n == 1)
        return 0;

    int mn = *min_element(nums.begin(), nums.end());

    vector<int> rem;
    bool removed = false;

    for (int x : nums) {
        if (x == mn && !removed)
            removed = true;
        else
            rem.push_back(x);
    }

    sort(rem.begin(), rem.end(), greater<int>());

    long long score = 0;
    int currentMax = mn;

    for (int x : rem) {
        currentMax = max(currentMax, x);
        score += (currentMax - mn);
    }

    return score;
}

int main() {
    vector<int> nums = {7,6,5};

    cout << maximumPrefixDifferenceScore(nums);

    return 0;
}