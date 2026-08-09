import java.util.Arrays;

public class MaxSumOfMin {

    public static int arrayPairSum(int[] arr) {

        //sorting the array then we will get pairs with maximum, minimum values to get the maximum sum   
        Arrays.sort(arr);

        int sum = 0;
        int i = 0;

        while (i < arr.length) {
            sum += arr[i];   // arr[i] is the minimum of the pair
            i += 2;     
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 8, 3, 10, 45};

        int result = arrayPairSum(arr);

        System.out.println("Maximum Sum of Minimums = " + result);
    }
}