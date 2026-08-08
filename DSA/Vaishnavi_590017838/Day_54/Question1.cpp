#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

int maxFrequencyElements(vector<int>& nums) {
    unordered_map<int, int> frequency;
    for(int num : nums) {
        frequency[num]++;
    }
    int maxFreq = 0;
    for(auto entry : frequency) {
        maxFreq = max(maxFreq, entry.second);
    }
    int answer = 0;
    for(auto entry : frequency) {
        if(entry.second == maxFreq) {
            answer += entry.second;
        }
    }
    return answer;
}

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;
    vector<int> nums(n);
    cout << "Enter the elements: ";
    for(int i = 0; i < n; i++) {
        cin >> nums[i];
    }
    cout << "Total maximum frequencies: "
         << maxFrequencyElements(nums);
    return 0;
}
