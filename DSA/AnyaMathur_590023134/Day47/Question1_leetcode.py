# Leetcode Problem 506
# Relative Ranks 

class Solution(object):
    def findRelativeRanks(self, score):
        players = []
        for i in range(len(score)):
            players.append((score[i], i))
        players.sort(reverse=True)
        answer = [""] * len(score)
        for i in range(len(players)):
            value, index = players[i]
            if i == 0:
                answer[index] = "Gold Medal"
            elif i == 1:
                answer[index] = "Silver Medal"
            elif i == 2:
                answer[index] = "Bronze Medal"
            else:
                answer[index] = str(i + 1)
        return answer