
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

vector<int> findAnagrams(string s, string p) {
    vector<int> ans;

    sort(p.begin(), p.end());

    int k = p.size();

    for (int i = 0; i <= s.size() - k; i++) {
        string temp = s.substr(i, k);
        sort(temp.begin(), temp.end());

        if (temp == p)
            ans.push_back(i);
    }

    return ans;
}