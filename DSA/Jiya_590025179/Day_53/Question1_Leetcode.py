class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        a=0
        for i in range(len(s)-2):
            b=set(s[i:i+3])
            if(len(b)==3):
                a=a+1
        return a        
