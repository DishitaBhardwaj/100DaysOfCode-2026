//Need to find all starting indices where an anagram appears

#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main()
{
    string log = "cbaebabacd";
    string pattern = "abc";

    vector<int> answer;

    if (pattern.size() > log.size())
    {
        return 0;
    }

    vector<int> need(26, 0);
    vector<int> window(26, 0);

    // frequency of pattern
    for (char ch : pattern)
    {
        need[ch - 'a']++;
    }

    int k = pattern.size();

    // first window
    for (int i = 0; i < k; i++)
    {
        window[log[i] - 'a']++;
    }

    if (window == need)
    {
        answer.push_back(0);
    }

    // slide the window
    for (int i = k; i < log.size(); i++)
    {
        window[log[i] - 'a']++;
        window[log[i - k] - 'a']--;

        if (window == need)
        {
            answer.push_back(i - k + 1);
        }
    }

    for (int index : answer)
    {
        cout << index << " ";
    }

    return 0;
}