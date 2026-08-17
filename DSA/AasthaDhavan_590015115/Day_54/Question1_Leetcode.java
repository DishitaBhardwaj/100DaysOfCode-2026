class Solution {
    public int maxFrequencyElements(int[] nums) {
        int m=0; //maximum
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            } else{
                hm.put(nums[i],1);
            } if(hm.containsKey(nums[i]) && hm.get(nums[i])>m){
                m=hm.get(nums[i]);
            }
        }
        int cnt=0;
        List<Integer> l=new ArrayList<>(hm.values());
        for(int n:l){
            if(n==m){
                cnt+=n;
            }
        }
        return cnt;
    }
}