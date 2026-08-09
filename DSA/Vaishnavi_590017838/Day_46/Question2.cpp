#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

long long maximumScore(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    vector<int> arranged;
    int left = 0;
    int right = nums.size() - 1;
    while(left <= right) {
        if(left == right) {
            arranged.push_back(nums[left]);
        }
        else {
            arranged.push_back(nums[left]);
            arranged.push_back(nums[right]);
        }

        left++;
        right--;
    }
    int currentMin = arranged[0];
    int currentMax = arranged[0];
    long long score = 0;
    for(int value : arranged) {
        currentMin = min(currentMin, value);
        currentMax = max(currentMax, value);
        score += (currentMax - currentMin);
    }
    return score;
}

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;
    vector<int> nums(n);
    cout << "Enter the array elements: ";
    for(int i = 0; i < n; i++)
        cin >> nums[i];
    cout << "Maximum Prefix Difference Score: "
         << maximumScore(nums);
    return 0;
}
