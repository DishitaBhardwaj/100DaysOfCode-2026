class Solution:
    def findRelativeRanks(self, score):
        sorted_scores = sorted(score, reverse=True)
        
        rank_map = {}
        for i in range(len(sorted_scores)):
            if i == 0:
                rank_map[sorted_scores[i]] = "Gold Medal"
            elif i == 1:
                rank_map[sorted_scores[i]] = "Silver Medal"
            elif i == 2:
                rank_map[sorted_scores[i]] = "Bronze Medal"
            else:
                rank_map[sorted_scores[i]] = str(i + 1)
        
        return [rank_map[s] for s in score]