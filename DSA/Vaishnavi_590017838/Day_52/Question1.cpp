class Solution {
public:
    bool areOccurrencesEqual(string s) {
        unordered_map<char, int> frequency;
        for(char ch : s) {
            frequency[ch]++;
        }
        int count = frequency.begin()->second;
        for(auto entry : frequency) {
            if(entry.second != count)
                return false;
        }
        return true;
    }
};
