#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

string footballWinner(vector<string>& goals)
{
    unordered_map<string, int> mp;
    for (string team : goals)
    {
        mp[team]++;
    }

    int maxGoals = 0;
    string winner = "";
    for (auto it : mp)
    {
        if (it.second > maxGoals)
        {
            maxGoals = it.second;
            winner = it.first;
        }
    }

    return winner;
}

int main()
{
    vector<string> goals = {"LIONS", "TIGERS", "LIONS", "LIONS"};

    cout << footballWinner(goals);

    return 0;
}