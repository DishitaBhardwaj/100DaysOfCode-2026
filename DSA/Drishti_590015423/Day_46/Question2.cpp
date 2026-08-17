#include <bits/stdc++.h>
using namespace std;

int maximizeSum(vector<int>& nums) {
    sort(nums.begin(), nums.end());

    int n = nums.size();
    int left = 0, right = n - 1;

    vector<int> arr;

    // Start with largest, then smallest
    while (left <= right) {
        arr.push_back(nums[right--]);

        if (left <= right)
            arr.push_back(nums[left++]);
    }

    int mn = arr[0];
    int mx = arr[0];
    int ans = 0;

    for (int x : arr) {
        mn = min(mn, x);
        mx = max(mx, x);

        ans += mx - mn;
    }

    return ans;
}
