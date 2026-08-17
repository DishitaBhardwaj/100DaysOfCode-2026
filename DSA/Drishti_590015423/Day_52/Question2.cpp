#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

vector<string> usernameRegistration(vector<string>& usernames) {
    unordered_map<string, int> mp;
    vector<string> result;

    for (string name : usernames) {
        if (mp.find(name) == mp.end()) {
            result.push_back("OK");
            mp[name] = 1;
        } else {
            string newName = name + to_string(mp[name]);
            while (mp.find(newName) != mp.end()) {
                mp[name]++;
                newName = name + to_string(mp[name]);
            }
            result.push_back(newName);
            mp[newName] = 1;
            mp[name]++;
        }
    }

    return result;
}
