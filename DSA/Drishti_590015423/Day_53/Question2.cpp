class Solution {
public:
    vector<int> findAnagrams(string log, string pattern) {
        vector<int> ans;

        if (log.size() < pattern.size())
            return ans;

        vector<int> pFreq(26, 0), wFreq(26, 0);

        // Frequency of pattern and first window
        for (int i = 0; i < pattern.size(); i++) {
            pFreq[pattern[i] - 'a']++;
            wFreq[log[i] - 'a']++;
        }

        // Check first window
        if (pFreq == wFreq)
            ans.push_back(0);

        // Slide the window
        for (int i = pattern.size(); i < log.size(); i++) {
            wFreq[log[i] - 'a']++;                         // Add new character
            wFreq[log[i - pattern.size()] - 'a']--;       // Remove old character

            if (pFreq == wFreq)
                ans.push_back(i - pattern.size() + 1);
        }

        return ans;
    }
};
