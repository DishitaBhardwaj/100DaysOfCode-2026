class Solution:
    def sortTheStudents(self, score, k):
        score.sort(key=lambda row: row[k], reverse=True)
        return score
        