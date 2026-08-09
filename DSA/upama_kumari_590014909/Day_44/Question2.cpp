#include<iostream>
#include<vector>
using namespace std;

string favouriteNumber(vector<int>& nums, int favoriteIndex, int k) {
    int fav = nums[favoriteIndex - 1];

    int greater = 0, equal = 0;

    for (int x : nums) {
        if (x > fav)
            greater++;
        else if (x == fav)
            equal++;
    }

    if (greater >= k)
        return "NO";
    else if (greater + equal <= k)
        return "YES";
    else
        return "MAYBE";
}

int main() {
    vector<int> nums = {4, 3, 3, 2, 3};
    int favoriteIndex = 2;
    int k = 2;

    cout << favouriteNumber(nums, favoriteIndex, k);
    return 0;
}