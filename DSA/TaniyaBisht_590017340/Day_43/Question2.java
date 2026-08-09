
import java.util.*;
class SPM{
    public static void main(String[] args){
        int[] arr = {1, 4, 3, 2};
        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0; i < arr.length; i += 2){
            sum += arr[i];
        }
        System.out.println("Maximum Sum:" + sum);
    }
}