
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> r = new ArrayList<>();
        for(int num : nums1){
            map.put(num,1);
        }
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) == 1){
                r.add(num);
                map.put(num, 0);
            }
        }
        int[] ans = new int[r.size()];
        for(int i=0; i<r.size(); i++){
            ans[i] = r.get(i);
        }
        return ans;
    }
}