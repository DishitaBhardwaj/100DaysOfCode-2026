#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;
class  Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        unordered_map<int, int> freq;

        for (int num : nums) {
            freq[num]++;
        }

        int maxFreq = 0;
        int ans = 0;

        for (auto it : freq) {
            if (it.second > maxFreq) {
                maxFreq = it.second;
                ans = it.second;
            }
            else if (it.second == maxFreq) {
                ans += it.second;
            }
        }

        return ans;
    }
};