#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        unordered_map<int, int> freq;

       
        for (int x : nums) {
            if (x % 2 == 0) {
                freq[x]++;
            }
        }

        int ans = -1;
        int maxFreq = 0;


        for (auto &it : freq) {
            int num = it.first;
            int cnt = it.second;

            if (cnt > maxFreq || (cnt == maxFreq && num < ans)) {
                maxFreq = cnt;
                ans = num;
            }
        }

        return ans;
    }
};

