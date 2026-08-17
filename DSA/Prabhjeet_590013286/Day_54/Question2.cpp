//Need to find the winning team by counting goals

#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

int main()
{
    vector<string> goals = {"A", "ABA", "ABA", "A", "A"};

    unordered_map<string, int> freq;

    string winner = "";
    int best = 0;

    for (string team : goals)
    {
        freq[team]++;

        if (freq[team] > best)
        {
            best = freq[team];
            winner = team;
        }
    }

    cout << winner;

    return 0;
}