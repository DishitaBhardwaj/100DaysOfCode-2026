class Solution:
    def findRelativeRanks(self,score:List[int])->List[str]:
        a=sorted(score,reverse=True)
        rank={}
        c=1
        for i in a:
            if c==1:
                rank[i]="Gold Medal"
            elif c==2:
                rank[i]="Silver Medal"
            elif c==3:
                rank[i]="Bronze Medal"
            else:
                rank[i]=str(c)
            c=c+1
        ans=[]
        for i in score:
            ans.append(rank[i])
        return ans
