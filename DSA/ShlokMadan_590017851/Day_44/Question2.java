import java.util.Arrays;
import java.util.Collections;
public class Question2 
{
    public static String favouriteNumber(Integer[] nums,int favoriteIndex,int k) 
    {
        int fav=nums[favoriteIndex-1];
        Arrays.sort(nums,Collections.reverseOrder());
        int greater=0;
        int equal=0;
        for(int num:nums) 
            {
            if(num>fav) 
                {
                greater++;
            }
            else if(num==fav) 
                {
                equal++;
            }
        }
        if(greater>=k) 
            {
            return "NO";
        }
        if(greater+equal<=k) 
            {
            return "YES";
        }
        return "MAYBE";
    }
    public static void main(String[] args) 
    {
        Integer[] nums={4,3,3,2,3};
        int favoriteIndex=2;
        int k=2;
        System.out.println(favouriteNumber(nums,favoriteIndex,k));
    }
}