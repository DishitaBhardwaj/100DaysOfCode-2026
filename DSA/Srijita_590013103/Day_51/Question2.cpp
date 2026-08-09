class Solution {
public:
    int firstInvalidRecord(vector<vector<string>>& deliveries) {
        unordered_map<string, unordered_map<string, string>> mp;

        for (int i = 0; i < deliveries.size(); i++) {
            string vendor = deliveries[i][0];
            string lot = deliveries[i][1];
            string cert = deliveries[i][2];

            if (!mp[vendor].count(lot)) {
                mp[vendor][lot] = cert;
            } else if (mp[vendor][lot] != cert) {
                return i;
            }
        }

        return -1;
    }
};