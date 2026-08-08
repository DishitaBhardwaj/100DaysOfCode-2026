#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

long long maximumPleasure(vector<int>& length, vector<int>& beauty, int k) {
    vector<pair<int, int>> songs;
    for(int i = 0; i < length.size(); i++) {
        songs.push_back({beauty[i], length[i]});
    }
    sort(songs.begin(), songs.end(),
         [](pair<int, int>& a, pair<int, int>& b) {
             return a.first > b.first;
         });
    priority_queue<int, vector<int>, greater<int>> smallestLengths;
    long long sum = 0;
    long long answer = 0;
    for(auto song : songs) {
        int currentBeauty = song.first;
        int currentLength = song.second;
        smallestLengths.push(currentLength);
        sum += currentLength;
        if(smallestLengths.size() > k) {
            sum -= smallestLengths.top();
            smallestLengths.pop();
        }
        long long pleasure = sum * currentBeauty;
        answer = max(answer, pleasure);
    }
    return answer;
}

int main() {
    int n;
    cout << "Enter the number of songs: ";
    cin >> n;
    vector<int> length(n);
    vector<int> beauty(n);
    cout << "Enter the song lengths: ";
    for(int i = 0; i < n; i++) {
        cin >> length[i];
    }
    cout << "Enter the beauty values: ";
    for(int i = 0; i < n; i++) {
        cin >> beauty[i];
    }
    int k;
    cout << "Enter k: ";
    cin >> k;
    cout << "Maximum Playlist Pleasure: "
         << maximumPleasure(length, beauty, k);
    return 0;
}
