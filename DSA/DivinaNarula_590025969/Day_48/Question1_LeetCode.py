# Sort the Students by Their Kth Score

class Solution(object):
    def sortTheStudents(self, score, k):
        """
        :type score: List[List[int]]
        :type k: int
        :rtype: List[List[int]]
        """
        score.sort(key=lambda row: row[k], reverse=True)
        return score