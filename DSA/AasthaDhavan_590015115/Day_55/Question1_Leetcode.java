class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> p=new PriorityQueue<>((a,b)-> (a[0]-b[0])); 
    for(int i=0;i<nums.length;i++){
        p.add(new int[]{nums[i],i});
        if(p.size()>k){
            p.poll();
        }
    }
 PriorityQueue<int[]> q=new PriorityQueue<>((a,b)-> (a[1]-b[1])); 
 while(!p.isEmpty()){
    q.add(p.poll());
 }
 int ans[]=new int[k];
 int idx=0;
    while(!q.isEmpty()){
        int[] val=q.poll();
        ans[idx++]=val[0];
    }

    return ans;
    }
}