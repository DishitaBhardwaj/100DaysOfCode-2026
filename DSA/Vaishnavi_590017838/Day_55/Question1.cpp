#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> maxSubsequence(vector<int>& nums, int k) {
    vector<pair<int, int>> elements;
    for(int i = 0; i < nums.size(); i++) {
        elements.push_back({nums[i], i});
    }
    sort(elements.begin(), elements.end(),
         [](pair<int, int>& a, pair<int, int>& b) {
             return a.first > b.first;
         });
    elements.resize(k);
    sort(elements.begin(), elements.end(),
         [](pair<int, int>& a, pair<int, int>& b) {
             return a.second < b.second;
         });
    vector<int> answer;
    for(auto element : elements) {
        answer.push_back(element.first);
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
    int k;
    cout << "Enter k: ";
    cin >> k;
    vector<int> result = maxSubsequence(nums, k);
    cout << "Maximum Sum Subsequence: ";
    for(int value : result) {
        cout << value << " ";
    }
    return 0;
}
