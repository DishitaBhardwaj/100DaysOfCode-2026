#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<int> findAnagrams(string log, string pattern) {
    vector<int> result;
    if(pattern.size() > log.size())
        return result;
    vector<int> patternCount(26, 0);
    vector<int> windowCount(26, 0);
    for(char ch : pattern)
        patternCount[ch - 'a']++;
    for(int i = 0; i < pattern.size(); i++)
        windowCount[log[i] - 'a']++;
    if(windowCount == patternCount)
        result.push_back(0);
    for(int i = pattern.size(); i < log.size(); i++) {
        windowCount[log[i] - 'a']++;
        windowCount[log[i - pattern.size()] - 'a']--;
        if(windowCount == patternCount)
            result.push_back(i - pattern.size() + 1);
    }
    return result;
}

int main() {
    string log, pattern;
    cout << "Enter the log string: ";
    cin >> log;
    cout << "Enter the pattern: ";
    cin >> pattern;
    vector<int> result = findAnagrams(log, pattern);
    cout << "Starting indices: ";
    for(int index : result)
        cout << index << " ";
    return 0;
}
