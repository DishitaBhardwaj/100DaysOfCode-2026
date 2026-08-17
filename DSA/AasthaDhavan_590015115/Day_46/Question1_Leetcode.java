class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> h=new HashSet<>();
        HashSet<Integer> res=new HashSet<>();

     
        for(int n:nums1){
            h.add(n);
        }
        for(int m:nums2){
            if(h.contains(m)){
                res.add(m);
            }
        }
        int ans[]=new int[res.size()];
        int i=0;
        for(int s:res){
            ans[i++]=s;
        }
        return ans;
    }

}