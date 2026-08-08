#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int maxFrequencyElements(vector<int>& nums)
{
    unordered_map<int, int> mp;
    for (int num : nums)
    {
        mp[num]++;
    }
    int maxFreq = 0;

    for (auto it : mp)
    {
        if (it.second > maxFreq)
        {
            maxFreq = it.second;
        }
    }
    int ans = 0;

    for (auto it : mp)
    {
        if (it.second == maxFreq)
        {
            ans += it.second;
        }
    }

    return ans;
}

int main()
{
    vector<int> nums = {1, 2, 2, 3, 1, 4};

    cout << maxFrequencyElements(nums);

    return 0;
}