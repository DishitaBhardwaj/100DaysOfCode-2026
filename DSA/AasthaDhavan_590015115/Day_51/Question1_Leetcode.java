class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        int freq=0;
        int ans=-1;
        for(int x: nums){
            if(x%2==0){
                int count=m.getOrDefault(x,0)+1;
                m.put(x,count);
                if(count>freq || (count==freq && x<ans)){
        ans=x;
        freq=count;
       }
            }
        }
        
       
        return ans;
    }
}