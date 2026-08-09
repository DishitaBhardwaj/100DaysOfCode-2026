#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<int> findAnagrams(string log, string pattern) {
    vector<int> ans;

    if (pattern.size() > log.size())
        return ans;

    vector<int> freqP(26, 0), freqW(26, 0);

    for (char c : pattern)
        freqP[c - 'a']++;

    int k = pattern.size();

    for (int i = 0; i < k; i++)
        freqW[log[i] - 'a']++;

    if (freqP == freqW)
        ans.push_back(0);

    for (int i = k; i < log.size(); i++) {
        freqW[log[i] - 'a']++;
        freqW[log[i - k] - 'a']--;

        if (freqP == freqW)
            ans.push_back(i - k + 1);
    }

    return ans;
}

int main() {
    string log, pattern;
    cin >> log >> pattern;

    vector<int> ans = findAnagrams(log, pattern);

    cout << "[";
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i];
        if (i != ans.size() - 1)
            cout << ", ";
    }
    cout << "]";

    return 0;
}