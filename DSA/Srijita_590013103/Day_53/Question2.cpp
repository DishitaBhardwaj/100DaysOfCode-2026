class Solution {
public:
    vector<int> findAnagrams(string s, string p) {

        vector<int> ans;

        int n = s.size();
        int m = p.size();

        if (m > n)
            return ans;

        vector<int> patternFreq(26, 0);
        vector<int> windowFreq(26, 0);

   
        for (char ch : p)
            patternFreq[ch - 'a']++;

        for (int i = 0; i < m; i++)
            windowFreq[s[i] - 'a']++;


        if (patternFreq == windowFreq)
            ans.push_back(0);


        for (int i = m; i < n; i++) {


            windowFreq[s[i - m] - 'a']--;

    
            windowFreq[s[i] - 'a']++;

  
            if (patternFreq == windowFreq)
                ans.push_back(i - m + 1);
        }

        return ans;
    }
};