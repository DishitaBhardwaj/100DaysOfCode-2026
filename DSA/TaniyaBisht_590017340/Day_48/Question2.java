
import java.util.*;
 class AM{
    public static void main(String[] args){
        int n = 4;
        int[] b = {4, 2, 2, 4, 6, 2};
        Arrays.sort(b);
        ArrayList<Integer> ans = new ArrayList<>();
        int index = 0;
        for (int i = n - 1; i >= 1; i--) {
            ans.add(b[index]);
            index += i;
        }
        ans.add(100);
        System.out.println("Reconstructed Array: " + ans);
    }
}