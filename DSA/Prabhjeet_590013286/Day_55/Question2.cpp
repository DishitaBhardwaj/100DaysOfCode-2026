//Need to maximize playlist pleasure

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main()
{
    vector<int> length = {4, 15, 3, 6};
    vector<int> beauty = {7, 1, 6, 8};
    int k = 3;

    vector<pair<int, int>> songs;

    // pair = {beauty, length}
    for (int i = 0; i < length.size(); i++)
    {
        songs.push_back({beauty[i], length[i]});
    }

    // process songs from highest beauty to lowest
    sort(songs.rbegin(), songs.rend());

    priority_queue<int, vector<int>, greater<int>> pq;

    long long sumLength = 0;
    long long answer = 0;

    for (auto song : songs)
    {
        pq.push(song.second);
        sumLength += song.second;

        // keep at most k songs
        if (pq.size() > k)
        {
            sumLength -= pq.top();
            pq.pop();
        }

        // current beauty is the minimum beauty
        answer = max(answer, sumLength * 1LL * song.first);
    }

    cout << answer;

    return 0;
}