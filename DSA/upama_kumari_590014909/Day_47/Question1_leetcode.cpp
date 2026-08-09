 #include <bits/stdc++.h>
using namespace std;

vector<string> findRelativeRanks(vector<int>& score) {
    int n = score.size();

    vector<pair<int, int>> arr;

    for (int i = 0; i < n; i++) {
        arr.push_back({score[i], i});
    }

    sort(arr.begin(), arr.end(), greater<pair<int, int>>());

    vector<string> ans(n);

    for (int i = 0; i < n; i++) {
        if (i == 0)
            ans[arr[i].second] = "Gold Medal";
        else if (i == 1)
            ans[arr[i].second] = "Silver Medal";
        else if (i == 2)
            ans[arr[i].second] = "Bronze Medal";
        else
            ans[arr[i].second] = to_string(i + 1);
    }

    return ans;
}

int main() {
    vector<int> score = {5,4,3,2,1};

    vector<string> ans = findRelativeRanks(score);

    for (string s : ans)
        cout << s << " ";

    return 0;
}