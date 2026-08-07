//Need to assign unique usernames

#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

int main()
{
    vector<string> usernames = {
        "abacaba",
        "acaba",
        "abacaba",
        "acab"
    };

    unordered_map<string, int> used;

    for (string name : usernames)
    {
        // username is available
        if (used.find(name) == used.end())
        {
            cout << "OK" << endl;
            used[name] = 1;
        }
        else
        {
            string newName = name + to_string(used[name]);

            cout << newName << endl;

            used[name]++;
            used[newName] = 1;
        }
    }

    return 0;
}