#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

string favouriteNumber(vector<int>& nums, int favouriteIndex, int k) {
    int favourite = nums[favouriteIndex - 1];
    sort(nums.begin(), nums.end(), greater<int>());
    int greaterCount = 0;
    int equalCount = 0;
    for(int value : nums) {
        if(value > favourite)
            greaterCount++;
        else if(value == favourite)
            equalCount++;
    }
    if(greaterCount >= k)
        return "NO";
    if(greaterCount + equalCount <= k)
        return "YES";
    return "MAYBE";
}

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;
    vector<int> nums(n);
    cout << "Enter the array elements: ";
    for(int i = 0; i < n; i++)
        cin >> nums[i];
    int favouriteIndex, k;
    cout << "Enter the favourite index: ";
    cin >> favouriteIndex;
    cout << "Enter the value of k: ";
    cin >> k;
    cout << favouriteNumber(nums, favouriteIndex, k);
    return 0;
}
