#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

string findWinner(vector<string>& goals) {
    unordered_map<string, int> score;
    for(string team : goals) {
        score[team]++;
    }
    string winner;
    int highestScore = 0;
    for(auto entry : score) {
        if(entry.second > highestScore) {
            highestScore = entry.second;
            winner = entry.first;
        }
    }
    return winner;
}

int main() {
    int n;
    cout << "Enter the number of goals: ";
    cin >> n;
    vector<string> goals(n);
    cout << "Enter the team name for each goal: ";
    for(int i = 0; i < n; i++) {
        cin >> goals[i];
    }
    cout << "Winning Team: " << findWinner(goals);
    return 0;
}
