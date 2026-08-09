#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

vector<string> registerUsers(vector<string>& requests) {
    unordered_map<string, int> users;
    vector<string> result;
    for(string name : requests) {
        if(users.count(name) == 0) {
            result.push_back("OK");
            users[name] = 1;
        }
        else {
            string newName = name + to_string(users[name]);
            while(users.count(newName)) {
                users[name]++;
                newName = name + to_string(users[name]);
            }
            result.push_back(newName);
            users[newName] = 1;
            users[name]++;
        }
    }
    return result;
}

int main() {
    int n;
    cout << "Enter the number of registration requests: ";
    cin >> n;
    vector<string> requests(n);
    cout << "Enter the usernames:\n";
    for(int i = 0; i < n; i++) {
        cin >> requests[i];
    }
    vector<string> result = registerUsers(requests);
    cout << "\nRegistration Results:\n";
    for(string value : result)
        cout << value << endl;
    return 0;
}
