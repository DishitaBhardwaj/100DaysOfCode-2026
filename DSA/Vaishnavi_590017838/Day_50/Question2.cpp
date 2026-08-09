#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int lastRockWeight(vector<int>& rocks) {
    priority_queue<int> pq;
    for(int weight : rocks)
        pq.push(weight);
    while(pq.size() > 1) {
        int first = pq.top();
        pq.pop();
        int second = pq.top();
        pq.pop();
        if(first != second)
            pq.push(first - second);
    }
    if(pq.empty())
        return 0;
    return pq.top();
}

int main() {
    int n;
    cout << "Enter the number of rocks: ";
    cin >> n;
    vector<int> rocks(n);
    cout << "Enter the rock weights: ";
    for(int i = 0; i < n; i++)
        cin >> rocks[i];
    cout << "Last Remaining Rock Weight: "
         << lastRockWeight(rocks);
    return 0;
}
