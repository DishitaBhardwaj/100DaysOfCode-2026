class Solution {
public:
    long long maxPleasure(vector<int>& length, vector<int>& beauty, int k) {
        int n = length.size();

        vector<pair<int, int>> songs;

        for (int i = 0; i < n; i++) {
            songs.push_back({beauty[i], length[i]});
        }

        // Beauty descending
        sort(songs.rbegin(), songs.rend());

        priority_queue<int, vector<int>, greater<int>> pq;

        long long sum = 0;
        long long ans = 0;

        for (auto [b, l] : songs) {
            pq.push(l);
            sum += l;

            if (pq.size() > k) {
                sum -= pq.top();
                pq.pop();
            }

            ans = max(ans, sum * b);
        }

        return ans;
    }
};