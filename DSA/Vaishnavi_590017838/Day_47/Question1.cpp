class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        vector<pair<int, int>> players;
        for(int i = 0; i < score.size(); i++) {
            players.push_back({score[i], i});
        }
        sort(players.begin(), players.end(), greater<pair<int, int>>());
        vector<string> answer(score.size());
        for(int i = 0; i < players.size(); i++) {
            int index = players[i].second;
            if(i == 0)
                answer[index] = "Gold Medal";
            else if(i == 1)
                answer[index] = "Silver Medal";
            else if(i == 2)
                answer[index] = "Bronze Medal";
            else
                answer[index] = to_string(i + 1);
        }
        return answer;
    }
};
