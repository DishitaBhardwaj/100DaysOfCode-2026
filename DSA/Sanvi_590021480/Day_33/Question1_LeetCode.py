class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        a=""
        depth=0
        for i in s:
            if i=='(':
                if depth>0:
                    a+=i
                depth+=1
            if i==')':
                depth-=1
                if depth>0:
                    a+=i
        return a
        
