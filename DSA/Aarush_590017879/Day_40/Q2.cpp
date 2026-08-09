#include <iostream>
#include <vector>
#include <deque>
using namespace std;

vector<int> highestTemperature(vector<int>& temperatures, int k) {
    vector<int> result;
    deque<int> dq;

    for (int i = 0; i < temperatures.size(); i++) {

        // Remove indices outside the current window
        if (!dq.empty() && dq.front() <= i - k) {
            dq.pop_front();
        }

        // Remove smaller temperatures from the back
        while (!dq.empty() &&
               temperatures[dq.back()] <= temperatures[i]) {
            dq.pop_back();
        }

        // Add current index
        dq.push_back(i);

        // Start adding answers once first window is complete
        if (i >= k - 1) {
            result.push_back(temperatures[dq.front()]);
        }
    }

    return result;
}

int main() {
    vector<int> temperatures = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;

    vector<int> result = highestTemperature(temperatures, k);

    cout << "Highest temperatures: ";

    for (int temp : result) {
        cout << temp << " ";
    }

    return 0;
}