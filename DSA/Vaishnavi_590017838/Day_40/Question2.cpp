#include <iostream>
#include <vector>
#include <deque>
using namespace std;

vector<int> maxTemperature(vector<int>& temperatures, int k) {
    deque<int> window;
    vector<int> answer;
    for(int i = 0; i < temperatures.size(); i++) {
        while(!window.empty() && window.front() <= i - k)
            window.pop_front();
        while(!window.empty() &&
              temperatures[window.back()] <= temperatures[i])
            window.pop_back();
        window.push_back(i);
        if(i >= k - 1)
            answer.push_back(temperatures[window.front()]);
    }
    return answer;
}

int main() {
    int n;
    cout << "Enter the number of temperature readings: ";
    cin >> n;
    vector<int> temperatures(n);
    cout << "Enter the temperature values: ";
    for(int i = 0; i < n; i++)
        cin >> temperatures[i];
    int k;
    cout << "Enter the window size: ";
    cin >> k;
    vector<int> result = maxTemperature(temperatures, k);
    cout << "Maximum temperature in each window: ";
    for(int value : result)
        cout << value << " ";
    return 0;
}
