class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        a=[]
        for i in range(len(s)):
            a.append(s[i:i+3])
        count=0
        for i in a:
            if len(set(i))==3:
                count+=1
        return count
        
