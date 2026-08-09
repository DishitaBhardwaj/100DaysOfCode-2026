package Day_46;
import java.util.HashSet;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> ans= new HashSet<>();
        HashSet<Integer> set=new HashSet<>();
        for(int num: nums1){
                set.add(num);
        }
        for (int num: nums2){
            if (set.contains(num)){
                ans.add(num);
            }
        }
        int[] arr= new int[ans.size()];
        int i=0;
        for (int num: ans){
            arr[i++]=num;
        }
        return arr;
    }
}