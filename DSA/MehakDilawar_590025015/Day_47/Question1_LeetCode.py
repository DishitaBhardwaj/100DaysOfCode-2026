from typing import List
class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        n = len(score)
        result = [""] * n
        ranked = sorted(enumerate(score), key=lambda x: x[1], reverse=True)
        for rank, (index, _) in enumerate(ranked):
            if rank == 0:
                result[index] = "Gold Medal"
            elif rank == 1:
                result[index] = "Silver Medal"
            elif rank == 2:
                result[index] = "Bronze Medal"
            else:
                result[index] = str(rank + 1)
        return result
        