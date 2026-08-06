class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        a={}
        for i in s:
            if i in a:
                a[i]=a[i]+1
            else:
                a[i]=1
        ans=list(a.values())
        for i in ans:
            if i!=ans[0]:
                return False
        return True
