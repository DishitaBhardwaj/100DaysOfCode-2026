#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arrayPairSum(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    int sum = 0;
    for(int i = 0; i < nums.size(); i += 2)
        sum += nums[i];
    return sum;
}

int main() {
    int n;
    cout << "Enter the value of n: ";
    cin >> n;
    vector<int> nums(2 * n);
    cout << "Enter " << 2 * n << " elements: ";
    for(int i = 0; i < 2 * n; i++)
        cin >> nums[i];
    cout << "Maximum sum of pair minimums: "
         << arrayPairSum(nums);
    return 0;
}
