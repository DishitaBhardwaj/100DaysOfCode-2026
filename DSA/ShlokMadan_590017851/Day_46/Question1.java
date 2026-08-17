import java.util.Arrays;
import java.util.HashSet;
public class Question1 
{
    public static int[] intersection(int[] nums1,int[] nums2) 
    {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> ans=new HashSet<>();
        for(int num:nums1) 
            {
            set1.add(num);
        }
        for(int num:nums2) 
            {
            if(set1.contains(num)) 
                {
                ans.add(num);
            }
        }
        int[] result=new int[ans.size()];
        int i=0;
        for(int num:ans) 
            {
            result[i++]=num;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
}