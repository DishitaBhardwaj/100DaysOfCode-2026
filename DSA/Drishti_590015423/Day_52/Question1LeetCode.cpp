class Solution {
public:
    bool areOccurrencesEqual(string s) {
        unordered_map<char, int> freq;

        for (char ch : s) {
            freq[ch]++;
        }

        int count = freq.begin()->second;

        for (auto it : freq) {
            if (it.second != count)
                return false;
        }

        return true;
    }
};
