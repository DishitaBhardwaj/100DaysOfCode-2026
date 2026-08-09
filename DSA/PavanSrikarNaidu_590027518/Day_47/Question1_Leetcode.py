class Solution:
    def findRelativeRanks(self, score):
        sorted_scores = sorted(score, reverse=True)
        rank = {}

        for i, s in enumerate(sorted_scores):
            if i == 0:
                rank[s] = "Gold Medal"
            elif i == 1:
                rank[s] = "Silver Medal"
            elif i == 2:
                rank[s] = "Bronze Medal"
            else:
                rank[s] = str(i + 1)

        return [rank[s] for s in score]


if __name__ == "__main__":
    score = [5, 4, 3, 2, 1]
    sol = Solution()
    print(sol.findRelativeRanks(score))