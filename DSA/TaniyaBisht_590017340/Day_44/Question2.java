
import java.util.*;
class FN{
    public static void main(String[] args){
        int[] nums = {4, 2, 1, 3, 5};
        int favoriteIndex = 2;
        int k = 3;
        int fav = nums[favoriteIndex - 1];
        Arrays.sort(nums);
        boolean removed = false;
        for(int i = nums.length - k; i < nums.length; i++){
            if (nums[i] == fav) {
                removed = true;
                break;
            }
        }
        if(removed){
            System.out.println("YES");
        } 
        else{
            System.out.println("NO");
        }
    }
}