//Need to maximize the sum of pair minimums

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    vector<int> nums = {1, 4, 3, 2};

    // sorting gives the best pairing
    sort(nums.begin(), nums.end());

    int sum = 0;

    // take every first element of each pair
    for (int i = 0; i < nums.size(); i += 2)
    {
        sum += nums[i];
    }

    cout << sum;

    return 0;
}