class Solution {
public:
    vector<vector<int>> sortTheStudents(vector<vector<int>>& score, int k) {
        sort(score.begin(), score.end(),
             [&](vector<int>& first, vector<int>& second) {
                 return first[k] > second[k];
             });
        return score;
    }
};
