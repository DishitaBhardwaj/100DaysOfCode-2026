class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        unordered_map<int, int> freq;

        for (int x : nums) {
            if (x % 2 == 0)
                freq[x]++;
        }

        int ans = -1;
        int maxFreq = 0;

        for (auto &it : freq) {
            int num = it.first;
            int f = it.second;

            if (f > maxFreq || (f == maxFreq && num < ans)) {
                maxFreq = f;
                ans = num;
            }
        }

        return ans;
    }
};